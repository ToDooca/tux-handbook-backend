package com.tuxhandbook.security;

import com.tuxhandbook.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final UserDetailsService userDetailsService;
    private static final String HEADER = HttpHeaders.AUTHORIZATION;
    private static final String PREFIX = "Bearer ";
    @Value("${jwt.secret-key:secret}")
    private String secretKey;
    @Value("${jwt.expire-length:7200000}")
    private long validityInMilliseconds;

    public String createToken(String username, Collection<? extends GrantedAuthority> roles) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("Tux")
                .claim("username", username)
                .claim("roles", roles.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication resolveToken(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader(HEADER);
        if (header == null) return null;
        if (!header.startsWith(PREFIX)) return null;
        String token = header.substring(PREFIX.length());
        Jws<Claims> decoded = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
        Claims claims = decoded.getBody();
        if (!claims.getExpiration().before(new Date())) return null;
        String username = claims.get("username", String.class);
        List<String> roles = claims.get("roles", List.class);
        return new UsernamePasswordAuthenticationToken(username, null, roles
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));
    }

}

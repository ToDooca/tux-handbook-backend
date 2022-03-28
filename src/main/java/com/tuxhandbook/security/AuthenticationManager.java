package com.tuxhandbook.security;

import com.tuxhandbook.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class
AuthenticationManager implements org.springframework.security.authentication.AuthenticationManager {
    private final UserDetailsService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = (User) userService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new BadCredentialsException("Invalid Credentials");

        return new UsernamePasswordAuthenticationToken(username, null, user.getRoles());
    }
}

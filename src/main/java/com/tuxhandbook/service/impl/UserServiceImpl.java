package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import com.tuxhandbook.repository.UserRepository;
import com.tuxhandbook.data.RegisterDTO;
import com.tuxhandbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("UserServiceImpl.user.notFound"));
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Role> findAllRolesById(Integer userId) {
        return findById(userId).getRoles();
    }

    @Override
    public List<Role> addRolesById(Integer userId, List<Role> roles) {
        User user = findById(userId);
        user.getRoles().addAll(roles);
        return userRepository.save(user).getRoles();
    }

    @Override
    public List<Role> setRolesById(Integer userId, List<Role> roles) {
        User user = findById(userId);
        user.setRoles(roles);
        return userRepository.save(user).getRoles();
    }

    @Override
    public List<Role> deleteRolesById(Integer userId, List<Role> roles) {
        User user = findById(userId);
        user.getRoles().removeAll(roles);
        return userRepository.save(user).getRoles();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(encodePassword(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setAbout(registerDTO.getAbout());

        return userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}

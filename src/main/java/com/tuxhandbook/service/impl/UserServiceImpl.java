package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import com.tuxhandbook.repository.UserRepository;
import com.tuxhandbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
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
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void deleteById(Long userId) {
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
}

package com.tuxhandbook.service;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User save(User user);

    User update(User user);

    User findById(Integer userId);

    User findByUsername(String username);

    List<Role> findAllRolesById(Integer userId);

    List<Role> addRolesById(Integer userId, List<Role> roles);

    List<Role> setRolesById(Integer userId, List<Role> roles);
    
    List<Role> deleteRolesById(Integer userId, List<Role> roles);

    void deleteById(Integer userId);
}

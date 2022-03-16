package com.tuxhandbook.service;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User save(User user);

    User update(User user);

    User findById(Integer userId);

    List<Role> findAllRolesById(Integer userId);

    List<Role> addRolesById(Integer userId, List<Role> roles);

    List<Role> setRolesById(Integer userId, List<Role> roles);
    
    List<Role> deleteRolesById(Integer userId, List<Role> roles);

    void deleteById(Integer userId);
}

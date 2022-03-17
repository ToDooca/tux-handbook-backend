package com.tuxhandbook.service;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface RoleService {

    List<Role> findAll(Sort sort);

    Role save(Role role);

    Role update(Role role);

    Role findById(Integer roleId);

    void deleteById(Integer roleId);

    List<User> findAllUsersById(Integer roleId);

    List<User> addUsersById(Integer roleId, List<User> users);

    List<User> setUsersById(Integer roleId, List<User> users);

    List<User> deleteUsersById(Integer roleId, List<User> users);
}

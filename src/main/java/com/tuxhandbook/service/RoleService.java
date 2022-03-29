package com.tuxhandbook.service;

import com.tuxhandbook.entity.Role;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RoleService {

    List<Role> findAll(Sort sort);

    Role save(Role role);

    Role update(Role role);

    Role findById(Integer roleId);

    void deleteById(Integer roleId);
}

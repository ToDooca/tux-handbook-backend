package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import com.tuxhandbook.repository.RoleRepository;
import com.tuxhandbook.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<Role> findAll(Sort sort) {
        return roleRepository.findAll(sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new NoSuchElementException("RoleServiceImpl.role.notFound"));
    }

    @Override
    public void deleteById(Integer roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public List<User> findAllUsersById(Integer roleId) {
        return findById(roleId).getUsers();
    }

    @Override
    public List<User> addUsersById(Integer roleId, List<User> users) {
        Role role = findById(roleId);
        role.getUsers().addAll(users);
        return roleRepository.save(role).getUsers();
    }

    @Override
    public List<User> setUsersById(Integer roleId, List<User> users) {
        Role role = findById(roleId);
        role.setUsers(users);
        return roleRepository.save(role).getUsers();
    }

    @Override
    public List<User> deleteUsersById(Integer roleId, List<User> users) {
        Role role = findById(roleId);
        role.getUsers().removeAll(users);
        return roleRepository.save(role).getUsers();
    }
}

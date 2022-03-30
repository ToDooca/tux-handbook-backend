package com.tuxhandbook.service.impl;

import com.tuxhandbook.entity.Role;
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
}

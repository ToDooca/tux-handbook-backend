package com.tuxhandbook.controller;

import com.tuxhandbook.entity.Role;
import com.tuxhandbook.entity.User;
import com.tuxhandbook.service.RoleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllRoles")
    public ResponseEntity<List<Role>> getAllRoles(@RequestParam(name = "sort", required = false) Sort sort){
        return ResponseEntity.ok(roleService.findAll(sort));
    }

    @GetMapping("/{roleId}")
    @ApiOperation(value = "", nickname = "getRoleById")
    public ResponseEntity<Role> getRoleById(@PathVariable String roleId) {
        return ResponseEntity.ok(roleService.findById(Integer.parseInt(roleId)));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveRole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.save(role));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateRole")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.update(role));
    }

    @DeleteMapping("/{roleId}")
    @ApiOperation(value = "", nickname = "deleteRoleById")
    public void deleteRoleById(@PathVariable Integer roleId) {
        roleService.deleteById(roleId);
    }
}

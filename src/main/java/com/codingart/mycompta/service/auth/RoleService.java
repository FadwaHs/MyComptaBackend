package com.codingart.mycompta.service.auth;

import com.codingart.mycompta.model.auth.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    Role getRole(Long id);
    List<Role> getAllRole();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}

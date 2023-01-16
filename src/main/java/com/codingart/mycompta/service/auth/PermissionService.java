package com.codingart.mycompta.service.auth;

import com.codingart.mycompta.model.auth.Permission;

import java.util.List;

public interface PermissionService {
    Permission addPermission(Permission permission);
    Permission getPermission(Long id);
    List<Permission> getAllPermission();
    Permission updatePermission(Long id, Permission permission);
    void deletePermission(Long id);
}

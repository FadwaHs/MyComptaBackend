package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Permission;

import java.util.List;

public interface PermissionService {
    Permission addPermission(Permission permission);
    Permission getPermission(Long id);
    List<Permission> getAllPermission();
    Permission updatePermission(Long id, Permission permission);
    void deletePermission(Long id);
}

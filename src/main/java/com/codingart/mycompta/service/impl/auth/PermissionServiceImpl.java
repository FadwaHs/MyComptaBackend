package com.codingart.mycompta.service.impl.auth;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.auth.Permission;
import com.codingart.mycompta.repository.auth.PermissionRepository;
import com.codingart.mycompta.service.auth.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final String message = "Permission not found for this id :: ";


    @Override
    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);

    }

    @Override
    public Permission getPermission(Long id) {
        return permissionRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission updatePermission( Long id, Permission permission) {
        permissionRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        permission.setId(id);
        return permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        permissionRepository.deleteById(id);
    }

}

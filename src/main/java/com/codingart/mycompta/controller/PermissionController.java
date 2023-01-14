package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Permission;
import com.codingart.mycompta.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id){
        return new ResponseEntity<>(permissionService.getPermission(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermission(){
        return new ResponseEntity<>(permissionService.getAllPermission(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Permission> createPermission(@Valid @RequestBody Permission permission){
        return new ResponseEntity<>(permissionService.addPermission(permission), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable Long id, @Valid @RequestBody Permission permission){
        return new ResponseEntity<>(permissionService.updatePermission(id,permission), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePermission(@PathVariable Long id){
        permissionService.deletePermission(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

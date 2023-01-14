package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Role;
import com.codingart.mycompta.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRole(){
        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@Valid @RequestBody Role role){
        return new ResponseEntity<>(roleService.addRole(role), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @Valid @RequestBody Role role){
        return new ResponseEntity<>(roleService.updateRole(id,role), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

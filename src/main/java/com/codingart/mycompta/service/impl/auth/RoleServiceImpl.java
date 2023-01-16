package com.codingart.mycompta.service.impl.auth;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.auth.Role;
import com.codingart.mycompta.repository.auth.RoleRepository;
import com.codingart.mycompta.service.auth.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final String message = "Role not found for this id :: ";


    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);

    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole( Long id, Role role) {
        roleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        roleRepository.deleteById(id);
    }

}

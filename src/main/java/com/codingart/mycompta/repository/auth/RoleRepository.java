package com.codingart.mycompta.repository.auth;

import com.codingart.mycompta.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}
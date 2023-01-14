package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
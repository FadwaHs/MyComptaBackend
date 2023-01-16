package com.codingart.mycompta.repository.auth;

import com.codingart.mycompta.model.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
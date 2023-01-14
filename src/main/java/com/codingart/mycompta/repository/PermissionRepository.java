package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
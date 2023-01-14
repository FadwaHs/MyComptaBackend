package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
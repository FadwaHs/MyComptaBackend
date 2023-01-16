package com.codingart.mycompta.repository.environment;

import com.codingart.mycompta.model.environment.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
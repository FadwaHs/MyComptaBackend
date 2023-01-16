package com.codingart.mycompta.repository.config;

import com.codingart.mycompta.model.config.Defaults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultsRepository extends JpaRepository<Defaults, Long> {
}
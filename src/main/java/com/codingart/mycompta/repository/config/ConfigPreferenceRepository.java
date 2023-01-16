package com.codingart.mycompta.repository.config;

import com.codingart.mycompta.model.config.ConfigPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigPreferenceRepository extends JpaRepository<ConfigPreference, Long> {
}
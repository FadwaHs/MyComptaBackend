package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.ConfigPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigPreferenceRepository extends JpaRepository<ConfigPreference, Long> {
}
package com.codingart.mycompta.repository.config;

import com.codingart.mycompta.model.config.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
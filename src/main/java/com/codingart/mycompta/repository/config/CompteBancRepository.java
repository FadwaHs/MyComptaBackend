package com.codingart.mycompta.repository.config;

import com.codingart.mycompta.model.config.CompteBanc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteBancRepository extends JpaRepository<CompteBanc, Long> {
}
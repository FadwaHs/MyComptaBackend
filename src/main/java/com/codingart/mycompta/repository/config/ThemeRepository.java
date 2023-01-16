package com.codingart.mycompta.repository.config;

import com.codingart.mycompta.model.config.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
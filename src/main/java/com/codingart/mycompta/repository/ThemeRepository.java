package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
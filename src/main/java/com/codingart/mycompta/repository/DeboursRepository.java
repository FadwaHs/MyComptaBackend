package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Debours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeboursRepository extends JpaRepository<Debours, Long> {
}
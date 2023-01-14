package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.FactureAcompte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureAcompteRepository extends JpaRepository<FactureAcompte, Long> {
}
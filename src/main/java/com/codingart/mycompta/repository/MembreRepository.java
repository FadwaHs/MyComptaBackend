package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Long> {
}
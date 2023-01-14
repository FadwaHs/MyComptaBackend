package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe, Long> {
}
package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
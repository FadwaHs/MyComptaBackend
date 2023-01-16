package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.model.facture.FactureAcompte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureAcompteRepository extends JpaRepository<FactureAcompte, Long> {
}
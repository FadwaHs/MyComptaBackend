package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.model.facture.FactureAvoir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureAvoirRepository extends JpaRepository<FactureAvoir, Long> {
}
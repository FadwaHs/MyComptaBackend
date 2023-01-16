package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.model.facture.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
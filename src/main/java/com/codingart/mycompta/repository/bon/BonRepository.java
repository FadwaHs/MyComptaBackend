package com.codingart.mycompta.repository.bon;

import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonRepository extends JpaRepository<Bons, Long> {
}

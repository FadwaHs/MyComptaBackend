package com.codingart.mycompta.repository.facturefournisseur;

import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}

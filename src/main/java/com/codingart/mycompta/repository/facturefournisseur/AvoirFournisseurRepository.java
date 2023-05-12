package com.codingart.mycompta.repository.facturefournisseur;

import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvoirFournisseurRepository extends JpaRepository<AvoireFournisseur, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  facture_fournisseur WHERE type_facturefournisseur = 'AvoirFournisseur' ",nativeQuery = true)
    String findLargestCode();
}

package com.codingart.mycompta.repository.facturefournisseur;

import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimpleFournisseurRepository extends JpaRepository<SimpleFournisseur, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  facture_fournisseur WHERE type_facturefournisseur = 'SimpleFournisseur' ",nativeQuery = true)
    String findLargestCode();
}

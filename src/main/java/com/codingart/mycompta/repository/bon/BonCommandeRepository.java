package com.codingart.mycompta.repository.bon;

import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BonCommandeRepository extends JpaRepository<BonsCommande, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  bons WHERE type_bon  = 'BonsCommande' ",nativeQuery = true)
    String findLargestCode();
}

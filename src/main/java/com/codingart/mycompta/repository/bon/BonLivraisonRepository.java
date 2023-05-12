package com.codingart.mycompta.repository.bon;

import com.codingart.mycompta.model.bon.BonLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BonLivraisonRepository extends JpaRepository<BonLivraison, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  bons WHERE type_bon  = 'BonLivraison' ",nativeQuery = true)
    String findLargestCode();
}

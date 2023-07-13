package com.codingart.mycompta.repository.bon;

import com.codingart.mycompta.enums.BCStatus;
import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BonCommandeRepository extends JpaRepository<BonsCommande, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  bons WHERE type_bon  = 'BonsCommande' ",nativeQuery = true)
    String findLargestCode();

    @Query(value = "select b from BonsCommande b  left join b.fournisseur.societe s left join b.fournisseur c left join b.motCleList m " +
            " where  concat_ws('-',b.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<BonsCommande> findByDataContaining(String data,  Pageable pageable);
    @Query(value = "select b from BonsCommande b  left join b.fournisseur.societe s left join b.fournisseur c left join b.motCleList m " +
            " where  concat_ws('-',b.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and b.bcStatus = ?2")
    Page<BonsCommande> findByDataContainingWithStatus(String data , BCStatus bcStatus, Pageable pageable);

    Page<BonsCommande> findBonCommandeByBcStatus(BCStatus bcStatus,Pageable pageable);

}

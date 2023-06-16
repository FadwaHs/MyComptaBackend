package com.codingart.mycompta.repository.bon;

import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.model.bon.BonLivraison;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BonLivraisonRepository extends JpaRepository<BonLivraison, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  bons WHERE type_bon  = 'BonLivraison' ",nativeQuery = true)
    String findLargestCode();

    @Query(value = "select b from BonLivraison b  left join b.fournisseur.societe s left join b.fournisseur c left join b.motCleList m " +
            " where  concat_ws('-',b.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<BonLivraison> findByDataContaining(String data,  Pageable pageable);

    @Query(value = "select b from BonLivraison b  left join b.fournisseur.societe s left join b.fournisseur c left join b.motCleList m " +
            " where  concat_ws('-',b.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and b.blStatus = ?2")
    Page<BonLivraison> findByDataContainingWithStatus(String data , BLStatus blStatus, Pageable pageable);

    Page<BonLivraison> findBonLivraisonByBlStatus(BLStatus blStatus,Pageable pageable);
}

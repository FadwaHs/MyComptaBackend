package com.codingart.mycompta.repository.facturefournisseur;

import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvoirFournisseurRepository extends JpaRepository<AvoireFournisseur, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  facture_fournisseur WHERE type_facturefournisseur = 'AvoirFournisseur' ",nativeQuery = true)
    String findLargestCode();

    @Query(value = "select f from AvoireFournisseur f  left join f.fournisseur.societe s left join f.fournisseur c left join f.motCleList m " +
            " where  concat_ws('-',f.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<AvoireFournisseur> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select f from AvoireFournisseur f  left join f.fournisseur.societe s left join f.fournisseur c left join f.motCleList m " +
            " where  concat_ws('-',f.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and f.status = ?2")
    Page<AvoireFournisseur> findByDataContainingWithStatus(String data , AvoireFournisseurStatus status, Pageable pageable);

    Page<AvoireFournisseur> findSimpleFounisseurByStatus(AvoireFournisseurStatus status,Pageable pageable);
}

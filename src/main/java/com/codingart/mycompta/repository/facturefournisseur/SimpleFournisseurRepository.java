package com.codingart.mycompta.repository.facturefournisseur;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.enums.LivraisonStatus;
import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimpleFournisseurRepository extends JpaRepository<SimpleFournisseur, Long> {

    @Query(value = "SELECT MAX(numero_interne) FROM  facture_fournisseur WHERE type_facturefournisseur = 'SimpleFournisseur' ",nativeQuery = true)
    String findLargestCode();

    @Query(value = "select f from SimpleFournisseur f  left join f.fournisseur.societe s left join f.fournisseur c left join f.motCleList m " +
            " where  concat_ws('-',f.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<SimpleFournisseur> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select f from SimpleFournisseur f  left join f.fournisseur.societe s left join f.fournisseur c left join f.motCleList m " +
            " where  concat_ws('-',f.numero_interne,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and f.status = ?2")
    Page<SimpleFournisseur> findByDataContainingWithStatus(String data , SimpleFournisseurStatus status, Pageable pageable);

    Page<SimpleFournisseur> findSimpleFounisseurByStatus(SimpleFournisseurStatus status,Pageable pageable);

    //Page<SimpleFournisseur> findSimpleFounisseurByLivraisonStatus(LivraisonStatus status, Pageable pageable);



}

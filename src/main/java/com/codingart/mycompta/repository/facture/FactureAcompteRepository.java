package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAcompte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FactureAcompteRepository extends JpaRepository<FactureAcompte, Long> {

    @Query(value = "select fa from FactureAcompte fa left join fa.devis d left join d.societe s left join d.client c left join fa.motCleList m " +
            " where  concat_ws('-',fa.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<FactureAcompte> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select fa from FactureAcompte fa left join fa.devis d left join d.societe s left join d.client c left join fa.motCleList m " +
            " where  concat_ws('-',fa.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and fa.status = ?2")
    Page<FactureAcompte> findByDataContainingWithStatus(String data , FactureAcompteStatus status, Pageable pageable);

    Page<FactureAcompte> findFactureAcompteByStatus(FactureAcompteStatus status,Pageable pageable);

    @Query("select fa1.cmp from FactureAcompte fa1 where fa1.cmp =( select max(fa2.cmp) from FactureAcompte fa2 )")
    Long selectLastCmp(Date date);
    @Query("select fa1.cmp from FactureAcompte fa1 where fa1.cmp =( select max(fa2.cmp) from FactureAcompte fa2 where year(fa2.date) = year(?1) ) ")
    Long selectLastCmpInYear(Date date);
    @Query("select fa1.cmp from FactureAcompte fa1 where fa1.cmp =( select max(fa2.cmp) from FactureAcompte fa2 where year(fa2.date) = year(?1) and month(fa2.date) = month(?1) ) ")
    Long selectLastCmpInMonth(Date date);
}
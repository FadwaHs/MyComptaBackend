package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.facture.FactureSimple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FactureSimpleRepository extends JpaRepository<FactureSimple, Long> {

    @Query(value = "select f from FactureSimple f  left join f.societe s left join f.client c left join f.motCleList m " +
            " where  concat_ws('-',f.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<FactureSimple> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select f from FactureSimple f  left join f.societe s left join f.client c left join f.motCleList m " +
            " where  concat_ws('-',f.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and f.status = ?2")
    Page<FactureSimple> findByDataContainingWithStatus(String data , FactureSimpleStatus status, Pageable pageable);

    Page<FactureSimple> findFactureSimpleByStatus(FactureSimpleStatus status,Pageable pageable);

    @Query("select f1.cmp from FactureSimple f1 where f1.cmp =( select max(f2.cmp) from FactureSimple f2 )")
    Long selectLastCmp(Date date);
    @Query("select f1.cmp from FactureSimple f1 where f1.cmp =( select max(f2.cmp) from FactureSimple f2 where year(f2.date) = year(?1) ) ")
    Long selectLastCmpInYear(Date date);
    @Query("select f1.cmp from FactureSimple f1 where f1.cmp =( select max(f2.cmp) from FactureSimple f2 where year(f2.date) = year(?1) and month(f2.date) = month(?1) ) ")
    Long selectLastCmpInMonth(Date date);

}
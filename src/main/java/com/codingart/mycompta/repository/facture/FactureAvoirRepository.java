package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.enums.FactureAvoirStatus;
import com.codingart.mycompta.model.facture.FactureAvoir;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FactureAvoirRepository extends JpaRepository<FactureAvoir, Long> {
    @Query(value = "select a from FactureAvoir a  left join a.societe s left join a.client c left join a.motCleList m " +
            " where  concat_ws('-',a.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<FactureAvoir> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select a from FactureAvoir a  left join a.societe s left join a.client c left join a.motCleList m " +
            " where  concat_ws('-',a.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and a.status = ?2")
    Page<FactureAvoir> findByDataContainingWithStatus(String data , FactureAvoirStatus status, Pageable pageable);

    Page<FactureAvoir> findFactureAvoirByStatus(FactureAvoirStatus status,Pageable pageable);

    @Query("select a1.cmp from FactureAvoir a1 where a1.cmp =( select max(a2.cmp) from FactureAvoir a2 )")
    Long selectLastCmp(Date date);
    @Query("select a1.cmp from FactureAvoir a1 where a1.cmp =( select max(a2.cmp) from FactureAvoir a2 where year(a2.date) = year(?1) ) ")
    Long selectLastCmpInYear(Date date);
    @Query("select a1.cmp from FactureAvoir a1 where a1.cmp =( select max(a2.cmp) from FactureAvoir a2 where year(a2.date) = year(?1) and month(a2.date) = month(?1) ) ")
    Long selectLastCmpInMonth(Date date);
}
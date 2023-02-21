package com.codingart.mycompta.repository.devis;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.enums.DevisStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DevisRepository extends JpaRepository<Devis, Long> {

    @Query(value = "select d from Devis d left join d.societe s left join d.client c left join d.motCleList m " +
            " where  concat_ws('-',d.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<Devis> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select d from Devis d left join d.societe s left join d.client c left join d.motCleList m " +
            " where  concat_ws('-',d.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and d.status = ?2")
    Page<Devis> findByDataContainingWithStatus(String data ,DevisStatus status, Pageable pageable);
    Page<Devis> findDevisByStatus(DevisStatus status,Pageable pageable);
}
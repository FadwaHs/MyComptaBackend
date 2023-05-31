package com.codingart.mycompta.repository.opportunite;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.OppStatus;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OpportuniteRepository extends JpaRepository<Opportunite, Long> {

    @Query(value = "SELECT MAX(code) FROM Opportunite")
    String findLargestCode();

    //++
    @Query(value = "select o from Opportunite o left join o.societe s left join o.client c left join o.motCleList m " +
            " where  concat_ws('-',o.code,o.intitule,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<Opportunite> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select o from Opportunite o left join o.societe s left join o.client c left join o.motCleList m " +
            " where  concat_ws('-',o.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1%  " +
            "and o.oppStatus = ?2")
    Page<Opportunite> findByDataContainingWithStatus(String data , OppStatus status, Pageable pageable);

    Page<Opportunite> findOpportuniteByOppStatus(OppStatus status,Pageable pageable);
}

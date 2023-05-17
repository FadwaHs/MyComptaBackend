package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query(value = "select f from FactureSimple f  left join f.societe s left join f.client c left join f.motCleList m " +
            " where  concat_ws('-',f.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<Facture> findBySimpleDataContaining(String data, Pageable pageable);

    @Query(value = "select a from FactureAvoir a  left join a.societe s left join a.client c left join a.motCleList m " +
            " where  concat_ws('-',a.code,s.name,concat(c.firstName,' ',c.lastName ),m.mot) like %?1% ")
    Page<Facture> findByAvoireDataContaining(String data, Pageable pageable);

}
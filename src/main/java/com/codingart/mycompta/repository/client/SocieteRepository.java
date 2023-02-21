package com.codingart.mycompta.repository.client;

import com.codingart.mycompta.model.client.Societe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SocieteRepository extends JpaRepository<Societe, Long> {
    @Query(value = "select s from Societe s left join s.address a left join s.motCleList m " +
            "where concat_ws('-',s.name,a.city,a.country,m.mot) like %?1%")
    Page<Societe> findByDataContaining(String data, Pageable pageable);
}
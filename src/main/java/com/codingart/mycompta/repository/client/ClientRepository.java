package com.codingart.mycompta.repository.client;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select c from Client c left join c.address a left join c.motCleList m left join c.societe.address sa " +
            "where concat_ws('-',concat(c.firstName,' ',c.lastName),a.city,a.country,m.mot,sa.city,sa.country) like %?1%")
    Page<Client> findByDataContaining(String data, Pageable pageable);

    @Query(value = "select c from Client c where c.societe is null")
    List<Client> selectAllClientPar();
    @Query(value = "select c from Client c where c.societe is not null ")
    List<Client> selectAllClientPro();

    @Query(value = "select new com.codingart.mycompta.model.client.Client(c.id,c.firstName,c.lastName) from Client c")
    List<Client> selectAllByIdAndFirstNameAndLastName();
}
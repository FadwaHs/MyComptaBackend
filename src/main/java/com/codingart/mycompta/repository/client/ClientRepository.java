package com.codingart.mycompta.repository.client;

import com.codingart.mycompta.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select c from Client c where c.societe is null")
    List<Client> selectAllClientPar();
    @Query(value = "select c from Client c where c.societe is not null ")
    List<Client> selectAllClientPro();
}
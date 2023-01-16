package com.codingart.mycompta.repository.client;

import com.codingart.mycompta.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
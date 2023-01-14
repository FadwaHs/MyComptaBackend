package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
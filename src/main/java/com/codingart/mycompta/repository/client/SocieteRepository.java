package com.codingart.mycompta.repository.client;

import com.codingart.mycompta.model.client.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe, Long> {
}
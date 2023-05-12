package com.codingart.mycompta.repository.client;

import com.codingart.mycompta.model.client.Secteur;
import com.codingart.mycompta.model.client.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecteurRepository extends JpaRepository<Secteur, Long> {
}

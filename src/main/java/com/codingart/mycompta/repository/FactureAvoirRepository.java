package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.FactureAvoir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureAvoirRepository extends JpaRepository<FactureAvoir, Long> {
}
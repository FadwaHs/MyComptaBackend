package com.codingart.mycompta.repository.config;

import com.codingart.mycompta.model.config.Numerotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumerotationRepository extends JpaRepository<Numerotation, Long> {
}
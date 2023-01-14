package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Numerotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumerotationRepository extends JpaRepository<Numerotation, Long> {
}
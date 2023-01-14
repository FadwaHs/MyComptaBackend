package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.FactureSimple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureSimpleRepository extends JpaRepository<FactureSimple, Long> {
}
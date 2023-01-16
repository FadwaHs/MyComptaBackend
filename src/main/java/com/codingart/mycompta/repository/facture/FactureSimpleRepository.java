package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.model.facture.FactureSimple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureSimpleRepository extends JpaRepository<FactureSimple, Long> {
}
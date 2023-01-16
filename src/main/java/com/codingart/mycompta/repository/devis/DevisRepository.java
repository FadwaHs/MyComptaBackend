package com.codingart.mycompta.repository.devis;

import com.codingart.mycompta.model.devis.Devis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevisRepository extends JpaRepository<Devis, Long> {
}
package com.codingart.mycompta.repository.comptabilite;

import com.codingart.mycompta.model.comptabilite.CompteCharge;
import com.codingart.mycompta.model.comptabilite.CompteTiers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteChargesRepository extends JpaRepository<CompteCharge, Long> {
}


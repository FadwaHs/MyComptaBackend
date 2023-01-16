package com.codingart.mycompta.repository.facture;

import com.codingart.mycompta.model.facture.Debours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeboursRepository extends JpaRepository<Debours, Long> {
}
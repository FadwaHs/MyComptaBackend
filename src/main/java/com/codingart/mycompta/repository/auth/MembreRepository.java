package com.codingart.mycompta.repository.auth;

import com.codingart.mycompta.model.auth.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Long> {
}
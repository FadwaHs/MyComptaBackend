package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.CompteBanc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteBancRepository extends JpaRepository<CompteBanc, Long> {
}
package com.codingart.mycompta.repository.opportunite;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.opportunite.Opportunite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OpportuniteRepository extends JpaRepository<Opportunite, Long> {

    @Query(value = "SELECT MAX(code) FROM Opportunite")
    String findLargestCode();
}

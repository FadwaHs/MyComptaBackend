package com.codingart.mycompta.repository.opportunite;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.opportunite.Opportunite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportuniteRepository extends JpaRepository<Opportunite, Long> {


}

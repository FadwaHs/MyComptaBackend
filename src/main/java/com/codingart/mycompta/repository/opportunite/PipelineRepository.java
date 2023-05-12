package com.codingart.mycompta.repository.opportunite;

import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.model.opportunite.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PipelineRepository extends JpaRepository<Pipeline, Long> {

    Optional<Pipeline> findByName(String name);

}

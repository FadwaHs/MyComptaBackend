package com.codingart.mycompta.service.opportunite;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Etape;
import com.codingart.mycompta.model.opportunite.Pipeline;

import java.util.List;

public interface PipelineService {

    Pipeline addPipeline(Pipeline pipeline);
    Pipeline getPipeline(Long id);
    List<Pipeline> getAllPipeline();
    Pipeline updatePipeline(Long id, Pipeline pipeline);
    void deletePipeline(Long id);

    List<Etape> getEtapeForPipeline(Long id);
    Pipeline getPipelineByName(String name);
}

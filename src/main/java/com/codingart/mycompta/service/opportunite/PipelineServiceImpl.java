package com.codingart.mycompta.service.opportunite;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.opportunite.Etape;
import com.codingart.mycompta.model.opportunite.Pipeline;
import com.codingart.mycompta.repository.opportunite.PipelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PipelineServiceImpl implements  PipelineService{

    private  final PipelineRepository pipelineRepository;
    private final String message = "pip not found for this id :: ";

    @Override
    public Pipeline addPipeline(Pipeline pipeline) {
        return pipelineRepository.save(pipeline);
    }

    @Override
    public Pipeline getPipeline(Long id) {
        return pipelineRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public Pipeline getPipelineByName(String name) {
        return pipelineRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Pipeline not found with name: " + name));
    }

    @Override
    public List<Pipeline> getAllPipeline() {
        return pipelineRepository.findAll();
    }

    @Override
    public Pipeline updatePipeline(Long id, Pipeline pipeline) {

        pipelineRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(message+id));
        pipeline.setId(id);
        return pipelineRepository.save(pipeline);
    }

    @Override
    public void deletePipeline(Long id) {
        pipelineRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        pipelineRepository.deleteById(id);
    }

    @Override
    public List<Etape> getEtapeForPipeline(Long id) {

        Optional<Pipeline> pipelineOptional = pipelineRepository.findById(id);
        if (pipelineOptional.isPresent()  ){

            Pipeline pipeline = pipelineOptional.get();

            pipeline.initializeListEtape();
            return pipeline.getEtapeList();
        }
        return Collections.emptyList();
    }

}

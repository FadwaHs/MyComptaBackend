package com.codingart.mycompta.controller.opportunite;


import com.codingart.mycompta.model.opportunite.Etape;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.model.opportunite.Pipeline;
import com.codingart.mycompta.service.opportunite.OpportuniteService;
import com.codingart.mycompta.service.opportunite.PipelineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pipelines")
@RequiredArgsConstructor
public class PipelineController {

    private final PipelineService pipelineService;

    @GetMapping("{id}")
    public ResponseEntity<Pipeline> getPipelineById(@PathVariable Long id){
        return new ResponseEntity<>(pipelineService.getPipeline(id), HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Pipeline> getPipelineByName(@PathVariable String name){
        return new ResponseEntity<>(pipelineService.getPipelineByName(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pipeline>> getAllPipeline(){
        return new ResponseEntity<>(pipelineService.getAllPipeline(), HttpStatus.OK);
    }

    @GetMapping("etape/{id}")
    public ResponseEntity<List<Etape>> getAllEtapeForPipeline(@PathVariable Long id ){
        return new ResponseEntity<>(pipelineService.getEtapeForPipeline(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pipeline> createPipeline(@Valid @RequestBody Pipeline pipeline){
        return new ResponseEntity<>(pipelineService.addPipeline(pipeline), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pipeline> updatePipeline(@PathVariable Long id, @Valid @RequestBody Pipeline pipeline){
        return new ResponseEntity<>(pipelineService.updatePipeline(id,pipeline), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePipeline(@PathVariable Long id){
        pipelineService.deletePipeline(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

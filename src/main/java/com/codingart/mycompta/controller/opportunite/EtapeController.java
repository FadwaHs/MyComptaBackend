package com.codingart.mycompta.controller.opportunite;


import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Etape;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.model.opportunite.Pipeline;
import com.codingart.mycompta.service.opportunite.EtapeService;
import com.codingart.mycompta.service.opportunite.EtapeServiceImpl;
import com.codingart.mycompta.service.opportunite.PipelineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etapes")
@RequiredArgsConstructor
public class EtapeController {


    private final EtapeService etapeService;

    @GetMapping("{id}")
    public ResponseEntity<Etape> getEtapeById(@PathVariable Long id){
        return new ResponseEntity<>(etapeService.getEtape(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Etape>> getAllEtape(){
        return new ResponseEntity<>(etapeService.getAllEtape(), HttpStatus.OK);
    }

    @GetMapping("opp/{id}")
    public ResponseEntity<List<Opportunite>> getAllOpportuniteForEtape(@PathVariable Long id ){
        return new ResponseEntity<>(etapeService.getOpportuniteForEtape(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Etape> createEtape(@Valid @RequestBody Etape etape){
        return new ResponseEntity<>(etapeService.addEtape(etape), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Etape> updateEtape(@PathVariable Long id, @Valid @RequestBody Etape etape){
        return new ResponseEntity<>(etapeService.updateEtape(id,etape), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEtape(@PathVariable Long id){
        etapeService.deleteEtape(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
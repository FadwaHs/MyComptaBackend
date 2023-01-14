package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Environment;
import com.codingart.mycompta.service.EnvironmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/environments")
@RequiredArgsConstructor
public class EnvironmentController {

    private final EnvironmentService environmentService;

    @GetMapping("{id}")
    public ResponseEntity<Environment> getEnvironmentById(@PathVariable Long id){
        return new ResponseEntity<>(environmentService.getEnvironment(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Environment>> getAllEnvironment(){
        return new ResponseEntity<>(environmentService.getAllEnvironment(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Environment> createEnvironment(@Valid @RequestBody Environment environment){
        return new ResponseEntity<>(environmentService.addEnvironment(environment), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Environment> updateEnvironment(@PathVariable Long id, @Valid @RequestBody Environment environment){
        return new ResponseEntity<>(environmentService.updateEnvironment(id,environment), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEnvironment(@PathVariable Long id){
        environmentService.deleteEnvironment(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

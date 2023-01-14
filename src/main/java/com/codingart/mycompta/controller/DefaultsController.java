package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Defaults;
import com.codingart.mycompta.service.DefaultsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defaults")
@RequiredArgsConstructor
public class DefaultsController {

    private final DefaultsService defaultsService;

    @GetMapping("{id}")
    public ResponseEntity<Defaults> getDefaultsById(@PathVariable Long id){
        return new ResponseEntity<>(defaultsService.getDefaults(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Defaults>> getAllDefaults(){
        return new ResponseEntity<>(defaultsService.getAllDefaults(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Defaults> createDefaults(@Valid @RequestBody Defaults defaults){
        return new ResponseEntity<>(defaultsService.addDefaults(defaults), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Defaults> updateDefaults(@PathVariable Long id, @Valid @RequestBody Defaults defaults){
        return new ResponseEntity<>(defaultsService.updateDefaults(id,defaults), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDefaults(@PathVariable Long id){
        defaultsService.deleteDefaults(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

package com.codingart.mycompta.controller.config;

import com.codingart.mycompta.model.config.ConfigAcompte;
import com.codingart.mycompta.service.config.ConfigAcompteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configAcomptes")
@RequiredArgsConstructor
public class ConfigAcompteController {

    private final ConfigAcompteService configAcompteService;

    @GetMapping("{id}")
    public ResponseEntity<ConfigAcompte> getConfigAcompteById(@PathVariable Long id){
        return new ResponseEntity<>(configAcompteService.getConfigAcompte(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConfigAcompte>> getAllConfigAcompte(){
        return new ResponseEntity<>(configAcompteService.getAllConfigAcompte(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigAcompte> createConfigAcompte(@Valid @RequestBody ConfigAcompte configAcompte){
        return new ResponseEntity<>(configAcompteService.addConfigAcompte(configAcompte), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConfigAcompte> updateConfigAcompte(@PathVariable Long id, @Valid @RequestBody ConfigAcompte configAcompte){
        return new ResponseEntity<>(configAcompteService.updateConfigAcompte(id,configAcompte), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConfigAcompte(@PathVariable Long id){
        configAcompteService.deleteConfigAcompte(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

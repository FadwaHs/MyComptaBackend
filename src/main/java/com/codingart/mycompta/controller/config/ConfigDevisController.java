package com.codingart.mycompta.controller.config;

import com.codingart.mycompta.model.config.ConfigDevis;
import com.codingart.mycompta.service.config.ConfigDevisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configDeviss")
@RequiredArgsConstructor
public class ConfigDevisController {

    private final ConfigDevisService configDevisService;

    @GetMapping("{id}")
    public ResponseEntity<ConfigDevis> getConfigDevisById(@PathVariable Long id){
        return new ResponseEntity<>(configDevisService.getConfigDevis(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConfigDevis>> getAllConfigDevis(){
        return new ResponseEntity<>(configDevisService.getAllConfigDevis(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigDevis> createConfigDevis(@Valid @RequestBody ConfigDevis configDevis){
        return new ResponseEntity<>(configDevisService.addConfigDevis(configDevis), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConfigDevis> updateConfigDevis(@PathVariable Long id, @Valid @RequestBody ConfigDevis configDevis){
        return new ResponseEntity<>(configDevisService.updateConfigDevis(id,configDevis), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConfigDevis(@PathVariable Long id){
        configDevisService.deleteConfigDevis(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

package com.codingart.mycompta.controller.config;

import com.codingart.mycompta.model.config.ConfigAvoir;
import com.codingart.mycompta.service.config.ConfigAvoirService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configAvoirs")
@RequiredArgsConstructor
public class ConfigAvoirController {

    private final ConfigAvoirService configAvoirService;

    @GetMapping("{id}")
    public ResponseEntity<ConfigAvoir> getConfigAvoirById(@PathVariable Long id){
        return new ResponseEntity<>(configAvoirService.getConfigAvoir(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConfigAvoir>> getAllConfigAvoir(){
        return new ResponseEntity<>(configAvoirService.getAllConfigAvoir(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigAvoir> createConfigAvoir(@Valid @RequestBody ConfigAvoir configAvoir){
        return new ResponseEntity<>(configAvoirService.addConfigAvoir(configAvoir), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConfigAvoir> updateConfigAvoir(@PathVariable Long id, @Valid @RequestBody ConfigAvoir configAvoir){
        return new ResponseEntity<>(configAvoirService.updateConfigAvoir(id,configAvoir), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConfigAvoir(@PathVariable Long id){
        configAvoirService.deleteConfigAvoir(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

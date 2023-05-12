package com.codingart.mycompta.controller.comptabilite;

import com.codingart.mycompta.model.comptabilite.CompteTiers;
import com.codingart.mycompta.service.comptabilite.CompteTiersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptetiers")
@RequiredArgsConstructor
public class CompteTiersController {

    private final CompteTiersService compteTiersService;

    @GetMapping("{id}")
    public ResponseEntity<CompteTiers> getCompteTiersById(@PathVariable Long id){
        return new ResponseEntity<>(compteTiersService.getCompteTiers(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompteTiers>> getAllCompteTiers(){
        return new ResponseEntity<>(compteTiersService.getAllCompteTiers(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompteTiers> createCompteTiers(@Valid @RequestBody CompteTiers compteTiers){
        return new ResponseEntity<>(compteTiersService.addCompteTiers(compteTiers), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CompteTiers> updateCompteTiers(@PathVariable Long id, @Valid @RequestBody CompteTiers compteTiers){
        return new ResponseEntity<>(compteTiersService.updateCompteTiers(id,compteTiers), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompteTiers(@PathVariable Long id){
        compteTiersService.deleteCompteTiers(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}

package com.codingart.mycompta.controller.infos_general;

import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.service.general_infos.MotCleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mots-cle")
@RequiredArgsConstructor
public class MotCleController {

    private final MotCleService motCleService;

    @GetMapping("{id}")
    public ResponseEntity<MotCle> getMotCleById(@PathVariable Long id){
        return new ResponseEntity<>(motCleService.getMotCle(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MotCle>> getAllMotCle(){
        return new ResponseEntity<>(motCleService.getAllMotCle(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MotCle> createMotCle(@Valid @RequestBody MotCle motCle){
        return new ResponseEntity<>(motCleService.addMotCle(motCle), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MotCle> updateMotCle(@PathVariable Long id, @Valid @RequestBody MotCle motCle){
        return new ResponseEntity<>(motCleService.updateMotCle(id,motCle), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMotCle(@PathVariable Long id){
        motCleService.deleteMotCle(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

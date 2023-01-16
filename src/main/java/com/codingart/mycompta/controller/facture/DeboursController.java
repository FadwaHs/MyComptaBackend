package com.codingart.mycompta.controller.facture;

import com.codingart.mycompta.model.facture.Debours;
import com.codingart.mycompta.service.facture.DeboursService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debours")
@RequiredArgsConstructor
public class DeboursController {

    private final DeboursService deboursService;

    @GetMapping("{id}")
    public ResponseEntity<Debours> getDeboursById(@PathVariable Long id){
        return new ResponseEntity<>(deboursService.getDebours(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Debours>> getAllDebours(){
        return new ResponseEntity<>(deboursService.getAllDebours(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Debours> createDebours(@Valid @RequestBody Debours debours){
        return new ResponseEntity<>(deboursService.addDebours(debours), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Debours> updateDebours(@PathVariable Long id, @Valid @RequestBody Debours debours){
        return new ResponseEntity<>(deboursService.updateDebours(id,debours), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDebours(@PathVariable Long id){
        deboursService.deleteDebours(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

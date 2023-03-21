package com.codingart.mycompta.controller.facture;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.enums.FactureAvoirStatus;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.service.facture.FactureAvoirService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/factures-avoir")
@RequiredArgsConstructor
public class FactureAvoirController {

    private final FactureAvoirService factureAvoirService;

    @GetMapping("{id}")
    public ResponseEntity<FactureAvoir> getFactureAvoirById(@PathVariable Long id){
        return new ResponseEntity<>(factureAvoirService.getFactureAvoir(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FactureAvoir>> getAllFactureAvoir(){
        return new ResponseEntity<>(factureAvoirService.getAllFactureAvoir(), HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListFactureAvoir(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) FactureAvoirStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(factureAvoirService.getListFactureAvoir(data,status,page,size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FactureAvoir> createFactureAvoir(@Valid @RequestBody FactureAvoir factureAvoir){
        return new ResponseEntity<>(factureAvoirService.addFactureAvoir(factureAvoir), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<FactureAvoir> updateFactureAvoir(@PathVariable Long id, @Valid @RequestBody FactureAvoir factureAvoir){
        return new ResponseEntity<>(factureAvoirService.updateFactureAvoir(id,factureAvoir), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFactureAvoir(@PathVariable Long id){
        factureAvoirService.deleteFactureAvoir(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

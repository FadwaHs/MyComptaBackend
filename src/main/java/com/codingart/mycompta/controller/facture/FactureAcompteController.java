package com.codingart.mycompta.controller.facture;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.service.facture.FactureAcompteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/factures-acompte")
@RequiredArgsConstructor
public class FactureAcompteController {

    private final FactureAcompteService factureAcompteService;

    @GetMapping("{id}")
    public ResponseEntity<FactureAcompte> getFactureAcompteById(@PathVariable Long id){
        return new ResponseEntity<>(factureAcompteService.getFactureAcompte(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FactureAcompte>> getAllFactureAcompte(){
        return new ResponseEntity<>(factureAcompteService.getAllFactureAcompte(), HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListFactureAcompte(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) FactureAcompteStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(factureAcompteService.getListFactureAcompte(data,status,page,size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FactureAcompte> createFactureAcompte(@Valid @RequestBody FactureAcompte factureAcompte){
        return new ResponseEntity<>(factureAcompteService.addFactureAcompte(factureAcompte), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<FactureAcompte> updateFactureAcompte(@PathVariable Long id, @Valid @RequestBody FactureAcompte factureAcompte){
        return new ResponseEntity<>(factureAcompteService.updateFactureAcompte(id,factureAcompte), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFactureAcompte(@PathVariable Long id){
        factureAcompteService.deleteFactureAcompte(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

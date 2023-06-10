package com.codingart.mycompta.controller.facture;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.service.facture.FactureSimpleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/factures-simple")
@RequiredArgsConstructor
public class FactureSimpleController {

    private final FactureSimpleService factureSimpleService;

    @GetMapping("{id}")
    public ResponseEntity<FactureSimple> getFactureSimpleById(@PathVariable Long id){
        return new ResponseEntity<>(factureSimpleService.getFactureSimple(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FactureSimple>> getAllFactureSimple(){
        return new ResponseEntity<>(factureSimpleService.getAllFactureSimple(), HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListFactureSimple(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) FactureSimpleStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(factureSimpleService.getListFactureSimple(data,status,page,size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FactureSimple> createFactureSimple(@Valid @RequestBody FactureSimple factureSimple){
        return new ResponseEntity<>(factureSimpleService.addFactureSimple(factureSimple), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<FactureSimple> updateFactureSimple(@PathVariable Long id, @Valid @RequestBody FactureSimple factureSimple){
        return new ResponseEntity<>(factureSimpleService.updateFactureSimple(id,factureSimple), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFactureSimple(@PathVariable Long id){
        factureSimpleService.deleteFactureSimple(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

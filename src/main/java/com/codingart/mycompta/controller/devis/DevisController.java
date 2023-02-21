package com.codingart.mycompta.controller.devis;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.enums.DevisStatus;
import com.codingart.mycompta.service.devis.DevisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/devis")
@RequiredArgsConstructor
public class DevisController {

    private final DevisService devisService;

    @GetMapping("{id}")
    public ResponseEntity<DevisDto> getDevisById(@PathVariable Long id){
        return new ResponseEntity<>(devisService.getDevis(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Devis>> getAllDevis(){
        return new ResponseEntity<>(devisService.getAllDevis(), HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListDevis(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) DevisStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(devisService.getListDevis(data,status,page,size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Devis> createDevis(@Valid @RequestBody Devis devis){
        return new ResponseEntity<>(devisService.addDevis(devis), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Devis> updateDevis(@PathVariable Long id, @Valid @RequestBody Devis devis){
        return new ResponseEntity<>(devisService.updateDevis(id,devis), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDevis(@PathVariable Long id){
        devisService.deleteDevis(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

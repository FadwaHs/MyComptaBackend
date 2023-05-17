package com.codingart.mycompta.controller.facture;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.service.facture.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {
    private final FactureService factureService;

    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures(){
        return new ResponseEntity<>(factureService.getAllFactures(), HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListFactures(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(factureService.getListFactures(data,page,size), HttpStatus.OK);
    }


}

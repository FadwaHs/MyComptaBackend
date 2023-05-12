package com.codingart.mycompta.controller.facturefournisseur;


import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.service.facture.FactureService;
import com.codingart.mycompta.service.facturefournisseur.FactureFournisseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/facturesfournisseur")
@RequiredArgsConstructor
public class FactureFournisseurController {

    private final FactureFournisseurService factureFournisseurService;

    @GetMapping
    public ResponseEntity<List<FactureFournisseur>> getAllFactureFournisseur(){
        return new ResponseEntity<>(factureFournisseurService.getAllFacturesFournisseur(), HttpStatus.OK);
    }


}

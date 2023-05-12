package com.codingart.mycompta.controller.bon;

import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.service.bon.BonService;
import com.codingart.mycompta.service.facturefournisseur.FactureFournisseurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bons")
@RequiredArgsConstructor
public class BonController {

    private final BonService bonService;

    @GetMapping
    public ResponseEntity<List<Bons>> getAllBons(){
        return new ResponseEntity<>(bonService.getAllBons(), HttpStatus.OK);
    }


}

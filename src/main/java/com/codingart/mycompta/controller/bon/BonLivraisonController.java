package com.codingart.mycompta.controller.bon;

import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.service.bon.BonCommandeService;
import com.codingart.mycompta.service.bon.BonLivraisonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bonLivraison")
@RequiredArgsConstructor
public class BonLivraisonController {


    private  final BonLivraisonService bonLivraisonService;

    @GetMapping("{id}")
    public ResponseEntity<BonLivraison> getBonLivraisonById(@PathVariable Long id){
        return new ResponseEntity<>(bonLivraisonService.getBonLivraison(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BonLivraison>> getAllBonLivraisons(){
        return new ResponseEntity<>(bonLivraisonService.getAllBonLivraison(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BonLivraison> createBonsCommande(@Valid @RequestBody BonLivraison bonLivraison){
        return new ResponseEntity<>(bonLivraisonService.addBonLivraison(bonLivraison), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BonLivraison> updateBonLivraison(@PathVariable Long id, @Valid @RequestBody BonLivraison bonLivraison){
        return new ResponseEntity<>(bonLivraisonService.updateBonLivraison(id,bonLivraison), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSBonLivraison(@PathVariable Long id){
        bonLivraisonService.deleteBonLivraison(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListBonLivraison(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) BLStatus blStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(bonLivraisonService.getListBonLivraison(data,blStatus,page,size), HttpStatus.OK);
    }

}

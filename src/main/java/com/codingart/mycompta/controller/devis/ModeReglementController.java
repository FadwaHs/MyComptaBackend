package com.codingart.mycompta.controller.devis;

import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.service.devis.ModeReglementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modeReglements")
@RequiredArgsConstructor
public class ModeReglementController {

    private final ModeReglementService modeReglementService;

    @GetMapping("{id}")
    public ResponseEntity<ModeReglement> getModeReglementById(@PathVariable Long id){
        return new ResponseEntity<>(modeReglementService.getModeReglement(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ModeReglement>> getAllModeReglement(){
        return new ResponseEntity<>(modeReglementService.getAllModeReglement(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModeReglement> createModeReglement(@Valid @RequestBody ModeReglement modeReglement){
        return new ResponseEntity<>(modeReglementService.addModeReglement(modeReglement), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ModeReglement> updateModeReglement(@PathVariable Long id, @Valid @RequestBody ModeReglement modeReglement){
        return new ResponseEntity<>(modeReglementService.updateModeReglement(id,modeReglement), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteModeReglement(@PathVariable Long id){
        modeReglementService.deleteModeReglement(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

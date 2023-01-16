package com.codingart.mycompta.controller.devis;

import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.service.devis.ConditionReglementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conditionReglements")
@RequiredArgsConstructor
public class ConditionReglementController {

    private final ConditionReglementService conditionReglementService;

    @GetMapping("{id}")
    public ResponseEntity<ConditionReglement> getConditionReglementById(@PathVariable Long id){
        return new ResponseEntity<>(conditionReglementService.getConditionReglement(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConditionReglement>> getAllConditionReglement(){
        return new ResponseEntity<>(conditionReglementService.getAllConditionReglement(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConditionReglement> createConditionReglement(@Valid @RequestBody ConditionReglement conditionReglement){
        return new ResponseEntity<>(conditionReglementService.addConditionReglement(conditionReglement), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConditionReglement> updateConditionReglement(@PathVariable Long id, @Valid @RequestBody ConditionReglement conditionReglement){
        return new ResponseEntity<>(conditionReglementService.updateConditionReglement(id,conditionReglement), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConditionReglement(@PathVariable Long id){
        conditionReglementService.deleteConditionReglement(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

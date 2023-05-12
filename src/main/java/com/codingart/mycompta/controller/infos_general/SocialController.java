package com.codingart.mycompta.controller.infos_general;

import com.codingart.mycompta.model.general_infos.Social;
import com.codingart.mycompta.service.general_infos.SocialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sociaux")
@RequiredArgsConstructor
public class SocialController {
    private final SocialService socialService;
    @GetMapping("{id}")
    public ResponseEntity<Social> getSocialById(@PathVariable Long id){
        return new ResponseEntity<>(socialService.getSocial(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Social>> getAllSocial(){
        return new ResponseEntity<>(socialService.getAllSocial(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Social> createSocial(@Valid @RequestBody Social social){
        return new ResponseEntity<>(socialService.addSocial(social), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Social> updateSocial(@PathVariable Long id, @Valid @RequestBody Social social){
        return new ResponseEntity<>(socialService.updateSocial(id,social), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSocial(@PathVariable Long id){
        socialService.deleteSocial(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}

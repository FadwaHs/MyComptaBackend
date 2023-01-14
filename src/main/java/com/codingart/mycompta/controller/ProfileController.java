package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Profile;
import com.codingart.mycompta.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id){
        return new ResponseEntity<>(profileService.getProfile(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfile(){
        return new ResponseEntity<>(profileService.getAllProfile(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@Valid @RequestBody Profile profile){
        return new ResponseEntity<>(profileService.addProfile(profile), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @Valid @RequestBody Profile profile){
        return new ResponseEntity<>(profileService.updateProfile(id,profile), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

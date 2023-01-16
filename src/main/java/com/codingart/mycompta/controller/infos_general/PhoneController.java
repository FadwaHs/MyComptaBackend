package com.codingart.mycompta.controller.infos_general;

import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.service.general_infos.PhoneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id){
        return new ResponseEntity<>(phoneService.getPhone(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhone(){
        return new ResponseEntity<>(phoneService.getAllPhone(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@Valid @RequestBody Phone phone){
        return new ResponseEntity<>(phoneService.addPhone(phone), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @Valid @RequestBody Phone phone){
        return new ResponseEntity<>(phoneService.updatePhone(id,phone), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePhone(@PathVariable Long id){
        phoneService.deletePhone(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

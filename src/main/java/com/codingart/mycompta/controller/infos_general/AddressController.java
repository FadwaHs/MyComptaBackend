package com.codingart.mycompta.controller.infos_general;

import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.service.general_infos.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.getAddress(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @Valid @RequestBody Address address){
        return new ResponseEntity<>(addressService.updateAddress(id,address), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

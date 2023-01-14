package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.Address;
import com.codingart.mycompta.repository.AddressRepository;
import com.codingart.mycompta.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final String message = "Address not found for this id :: ";


    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);

    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress( Long id, Address address) {
        addressRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        address.setId(id);
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        addressRepository.deleteById(id);
    }

}

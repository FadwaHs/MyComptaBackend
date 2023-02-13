package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.repository.general_infos.AddressRepository;
import com.codingart.mycompta.service.general_infos.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final String message = "Address not found for this id :: ";

    private static Address currentAddress;
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
        currentAddress = addressRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        address.setId(id);
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        addressRepository.deleteById(id);
    }

}

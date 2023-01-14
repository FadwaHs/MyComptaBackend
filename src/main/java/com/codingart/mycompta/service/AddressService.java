package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Address;
import java.util.List;

public interface AddressService {

    Address addAddress(Address address);
    Address getAddress(Long id);
    List<Address> getAllAddress();
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);

}

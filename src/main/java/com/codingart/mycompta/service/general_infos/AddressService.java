package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.model.general_infos.Address;
import java.util.List;

public interface AddressService {

    Address addAddress(Address address);
    Address getAddress(Long id);
    List<Address> getAllAddress();
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);

}

package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.model.general_infos.Phone;

import java.util.List;

public interface PhoneService {
    Phone addPhone(Phone phone);
    Phone getPhone(Long id);
    List<Phone> getAllPhone();
    Phone updatePhone(Long id, Phone phone);
    void deletePhone(Long id);
}

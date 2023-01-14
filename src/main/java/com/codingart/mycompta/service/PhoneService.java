package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Phone;

import java.util.List;

public interface PhoneService {
    Phone addPhone(Phone phone);
    Phone getPhone(Long id);
    List<Phone> getAllPhone();
    Phone updatePhone(Long id, Phone phone);
    void deletePhone(Long id);
}

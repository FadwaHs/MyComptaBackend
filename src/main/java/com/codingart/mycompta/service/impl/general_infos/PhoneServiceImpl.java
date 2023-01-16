package com.codingart.mycompta.service.impl.general_infos;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.repository.general_infos.PhoneRepository;
import com.codingart.mycompta.service.general_infos.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final String message = "Phone not found for this id :: ";


    @Override
    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);

    }

    @Override
    public Phone getPhone(Long id) {
        return phoneRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Phone> getAllPhone() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone updatePhone( Long id, Phone phone) {
        phoneRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        phone.setId(id);
        return phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(Long id) {
        phoneRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        phoneRepository.deleteById(id);
    }

}

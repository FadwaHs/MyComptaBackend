package com.codingart.mycompta.service.impl.facture;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facture.Debours;
import com.codingart.mycompta.repository.facture.DeboursRepository;
import com.codingart.mycompta.service.facture.DeboursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeboursServiceImpl implements DeboursService {

    private final DeboursRepository deboursRepository;
    private final String message = "Debours not found for this id :: ";


    @Override
    public Debours addDebours(Debours debours) {
        return deboursRepository.save(debours);

    }

    @Override
    public Debours getDebours(Long id) {
        return deboursRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Debours> getAllDebours() {
        return deboursRepository.findAll();
    }

    @Override
    public Debours updateDebours( Long id, Debours debours) {
        deboursRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        debours.setId(id);
        return deboursRepository.save(debours);
    }

    @Override
    public void deleteDebours(Long id) {
        deboursRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        deboursRepository.deleteById(id);
    }

}

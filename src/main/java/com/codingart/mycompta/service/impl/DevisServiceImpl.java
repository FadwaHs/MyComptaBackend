package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.Devis;
import com.codingart.mycompta.repository.DevisRepository;
import com.codingart.mycompta.service.DevisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DevisServiceImpl implements DevisService {

    private final DevisRepository devisRepository;
    private final String message = "Devis not found for this id :: ";


    @Override
    public Devis addDevis(Devis devis) {
        return devisRepository.save(devis);

    }

    @Override
    public Devis getDevis(Long id) {
        return devisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    @Override
    public Devis updateDevis( Long id, Devis devis) {
        devisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        devis.setId(id);
        return devisRepository.save(devis);
    }

    @Override
    public void deleteDevis(Long id) {
        devisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        devisRepository.deleteById(id);
    }

}

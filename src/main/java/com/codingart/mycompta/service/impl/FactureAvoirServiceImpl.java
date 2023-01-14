package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.FactureAvoir;
import com.codingart.mycompta.repository.FactureAvoirRepository;
import com.codingart.mycompta.service.FactureAvoirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureAvoirServiceImpl implements FactureAvoirService {

    private final FactureAvoirRepository factureAvoirRepository;
    private final String message = "FactureAvoir not found for this id :: ";


    @Override
    public FactureAvoir addFactureAvoir(FactureAvoir factureAvoir) {
        return factureAvoirRepository.save(factureAvoir);

    }

    @Override
    public FactureAvoir getFactureAvoir(Long id) {
        return factureAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<FactureAvoir> getAllFactureAvoir() {
        return factureAvoirRepository.findAll();
    }

    @Override
    public FactureAvoir updateFactureAvoir( Long id, FactureAvoir factureAvoir) {
        factureAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAvoir.setId(id);
        return factureAvoirRepository.save(factureAvoir);
    }

    @Override
    public void deleteFactureAvoir(Long id) {
        factureAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAvoirRepository.deleteById(id);
    }

}

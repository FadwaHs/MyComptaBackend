package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.FactureSimple;
import com.codingart.mycompta.repository.FactureSimpleRepository;
import com.codingart.mycompta.service.FactureSimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureSimpleServiceImpl implements FactureSimpleService {

    private final FactureSimpleRepository factureSimpleRepository;
    private final String message = "FactureSimple not found for this id :: ";


    @Override
    public FactureSimple addFactureSimple(FactureSimple factureSimple) {
        return factureSimpleRepository.save(factureSimple);

    }

    @Override
    public FactureSimple getFactureSimple(Long id) {
        return factureSimpleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<FactureSimple> getAllFactureSimple() {
        return factureSimpleRepository.findAll();
    }

    @Override
    public FactureSimple updateFactureSimple( Long id, FactureSimple factureSimple) {
        factureSimpleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureSimple.setId(id);
        return factureSimpleRepository.save(factureSimple);
    }

    @Override
    public void deleteFactureSimple(Long id) {
        factureSimpleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureSimpleRepository.deleteById(id);
    }

}

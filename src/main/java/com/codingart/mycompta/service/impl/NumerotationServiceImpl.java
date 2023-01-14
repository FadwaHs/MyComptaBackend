package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.Numerotation;
import com.codingart.mycompta.repository.NumerotationRepository;
import com.codingart.mycompta.service.NumerotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NumerotationServiceImpl implements NumerotationService {

    private final NumerotationRepository numerotationRepository;
    private final String message = "Numerotation not found for this id :: ";


    @Override
    public Numerotation addNumerotation(Numerotation numerotation) {
        return numerotationRepository.save(numerotation);

    }

    @Override
    public Numerotation getNumerotation(Long id) {
        return numerotationRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Numerotation> getAllNumerotation() {
        return numerotationRepository.findAll();
    }

    @Override
    public Numerotation updateNumerotation( Long id, Numerotation numerotation) {
        numerotationRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        numerotation.setId(id);
        return numerotationRepository.save(numerotation);
    }

    @Override
    public void deleteNumerotation(Long id) {
        numerotationRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        numerotationRepository.deleteById(id);
    }

}

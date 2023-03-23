package com.codingart.mycompta.service.config;

import com.codingart.mycompta.enums.ResetCounter;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.Numerotation;
import com.codingart.mycompta.repository.config.NumerotationRepository;
import com.codingart.mycompta.service.config.NumerotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NumerotationServiceImpl implements NumerotationService {

    private final NumerotationRepository numerotationRepository;
    private final String message = "Numerotation not found for this id :: ";


    @Override
    public void initNumerotation() {
        Numerotation numerotation = Numerotation.builder()
                .id(1L).format("<doc><aa>-<mm>-<cmp>").minCounterSize(3).resetCounter(ResetCounter.YEAR)
                .startCounterDevis(1).startCounterFacture(1).startCounterAvoir(1).startCounterAcompte(1)
                .build();
        numerotationRepository.save(numerotation);
    }

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

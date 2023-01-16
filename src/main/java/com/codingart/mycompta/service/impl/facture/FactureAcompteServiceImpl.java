package com.codingart.mycompta.service.impl.facture;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.repository.facture.FactureAcompteRepository;
import com.codingart.mycompta.service.facture.FactureAcompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureAcompteServiceImpl implements FactureAcompteService {

    private final FactureAcompteRepository factureAcompteRepository;
    private final String message = "FactureAcompte not found for this id :: ";


    @Override
    public FactureAcompte addFactureAcompte(FactureAcompte factureAcompte) {
        return factureAcompteRepository.save(factureAcompte);

    }

    @Override
    public FactureAcompte getFactureAcompte(Long id) {
        return factureAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<FactureAcompte> getAllFactureAcompte() {
        return factureAcompteRepository.findAll();
    }

    @Override
    public FactureAcompte updateFactureAcompte( Long id, FactureAcompte factureAcompte) {
        factureAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAcompte.setId(id);
        return factureAcompteRepository.save(factureAcompte);
    }

    @Override
    public void deleteFactureAcompte(Long id) {
        factureAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAcompteRepository.deleteById(id);
    }

}

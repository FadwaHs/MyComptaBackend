package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.repository.facture.FactureRepository;
import com.codingart.mycompta.util.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService{

    private final FactureRepository factureRepository;
    private final String message = "FactureSimple not found for this id :: ";
    private final FormatService formatService;
    @Override
    public Facture addFacture(Facture facture) {
        return null;
    }

    @Override
    public Facture getFacture(Long id) {
        return null;
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture updateFacture(Long id, Facture facture) {
        return null;
    }

    @Override
    public void deleteFacture(Long id) {

    }
}

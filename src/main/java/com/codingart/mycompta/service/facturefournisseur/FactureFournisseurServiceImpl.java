package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.repository.facturefournisseur.FactureFournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureFournisseurServiceImpl implements  FactureFournisseurService {

    private final FactureFournisseurRepository factureFournisseurRepository;
    @Override
    public List<FactureFournisseur> getAllFacturesFournisseur() {
        return factureFournisseurRepository.findAll();
    }
}

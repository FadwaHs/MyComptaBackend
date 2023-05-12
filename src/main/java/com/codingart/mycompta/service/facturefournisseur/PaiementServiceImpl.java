package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facturefournisseur.Paiement;
import com.codingart.mycompta.repository.facturefournisseur.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService{

    private final PaiementRepository paiementRepository;
    private final String message = "Paiement not found for this id :: ";

    @Override
    public List<Paiement> getAllPaiement() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);

    }

    @Override
    public Paiement getPaiement(Long id) {
        return paiementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }
    @Override
    public Paiement updatePaiement( Long id, Paiement paiement) {
        paiementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        paiement.setId(id);
        return paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(Long id) {
        paiementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        paiementRepository.deleteById(id);
    }


}

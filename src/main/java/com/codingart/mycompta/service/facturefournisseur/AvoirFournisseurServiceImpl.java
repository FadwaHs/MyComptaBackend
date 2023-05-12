package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.repository.facturefournisseur.AvoirFournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AvoirFournisseurServiceImpl implements AvoirFournisseurService{

    private final AvoirFournisseurRepository avoirFournisseurRepository;
    private final String message = "AvoirFournisseur not found for this id :: ";
    private  static int count =0;


    @Override
    public AvoireFournisseur addAvoireFournisseur(AvoireFournisseur avoirFournisseur) {

        avoirFournisseur.setDate_creation(new Date());
        // get the largest code value from the database
        String largestCode = avoirFournisseurRepository.findLargestCode();
        int count = Integer.parseInt(largestCode.substring(4)) + 1;
        String code = String.format("F_AVR-%05d", count);
        avoirFournisseur.setNumero_interne(code);

        return avoirFournisseurRepository.save(avoirFournisseur);
    }

    @Override
    public AvoireFournisseur getAvoireFournisseur(Long id) {
        return avoirFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<AvoireFournisseur> getAllAvoireFournisseur() {
        return avoirFournisseurRepository.findAll();
    }

    @Override
    public AvoireFournisseur updateAvoireFournisseur(Long id, AvoireFournisseur avoirFournisseur) {

        avoirFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        avoirFournisseur.setId(id);
        return avoirFournisseurRepository.save(avoirFournisseur);
}

    @Override
    public void deleteAvoireFournisseur(Long id) {
        avoirFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        avoirFournisseurRepository.deleteById(id);
    }
}

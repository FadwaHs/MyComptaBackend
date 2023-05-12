package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;

import java.util.List;

public interface AvoirFournisseurService {

    AvoireFournisseur addAvoireFournisseur(AvoireFournisseur avoirFournisseur);
    AvoireFournisseur getAvoireFournisseur(Long id);
    List<AvoireFournisseur> getAllAvoireFournisseur();
    AvoireFournisseur updateAvoireFournisseur(Long id, AvoireFournisseur avoirFournisseur);
    void deleteAvoireFournisseur(Long id);
}

package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;

import java.util.List;
import java.util.Map;

public interface AvoirFournisseurService {

    AvoireFournisseur addAvoireFournisseur(AvoireFournisseur avoirFournisseur);
    AvoireFournisseur getAvoireFournisseur(Long id);
    List<AvoireFournisseur> getAllAvoireFournisseur();
    AvoireFournisseur updateAvoireFournisseur(Long id, AvoireFournisseur avoirFournisseur);
    void deleteAvoireFournisseur(Long id);

    Map<String,Object> getListAvoirFournsseur(String data, AvoireFournisseurStatus status, int page, int size);

}

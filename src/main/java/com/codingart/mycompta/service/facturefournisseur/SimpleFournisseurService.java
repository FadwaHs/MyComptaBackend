package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;

import java.util.List;
import java.util.Map;

public interface SimpleFournisseurService {
    SimpleFournisseur addSimpleFournisseur(SimpleFournisseur simpleFournisseur);
    SimpleFournisseur getSimpleFournisseur(Long id);
    List<SimpleFournisseur> getAllSimpleFournisseur();
    SimpleFournisseur updateSimpleFournisseur(Long id, SimpleFournisseur simpleFournisseur);
    void deleteSimpleFournisseur(Long id);


}

package com.codingart.mycompta.service.fournisseur;

import com.codingart.mycompta.dto.ClientDto;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.fournisseur.Fournisseur;

import java.util.List;
import java.util.Map;

public interface FournisseurService {
    Fournisseur addFournisseur(Fournisseur fournisseur);
    List<Fournisseur> getAllFournisseur();
    Fournisseur getFournisseur(Long id);
    Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);
    void deleteFournisseur(Long id);

    List<SimpleFournisseur> getAllSimple(Long id);
    List<AvoireFournisseur> getAllAvoire(Long id);

    List<BonsCommande> getAllBonsCommande(Long id);
    List<BonLivraison> getAllBonLivraison(Long id);

}

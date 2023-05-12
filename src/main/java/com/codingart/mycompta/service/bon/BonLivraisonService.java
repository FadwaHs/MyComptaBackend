package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.model.bon.BonLivraison;

import java.util.List;

public interface BonLivraisonService {

    BonLivraison addBonLivraison(BonLivraison bonLivraison);
    BonLivraison getBonLivraison(Long id);
    List<BonLivraison> getAllBonLivraison();
    BonLivraison updateBonLivraison(Long id, BonLivraison bonLivraison);
    void deleteBonLivraison(Long id);
}

package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.bon.BonLivraison;

import java.util.List;
import java.util.Map;

public interface BonLivraisonService {

    BonLivraison addBonLivraison(BonLivraison bonLivraison);
    BonLivraison getBonLivraison(Long id);
    List<BonLivraison> getAllBonLivraison();
    BonLivraison updateBonLivraison(Long id, BonLivraison bonLivraison);
    void deleteBonLivraison(Long id);
    Map<String,Object> getListBonLivraison(String data, BLStatus blStatus, int page, int size);
}

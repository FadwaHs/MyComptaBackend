package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.model.bon.BonsCommande;

import java.util.List;

public interface BonCommandeService {
    BonsCommande addBonsCommande(BonsCommande bonsCommande);
    BonsCommande getBonsCommande(Long id);
    List<BonsCommande> getAllBonsCommande();
    BonsCommande updateBonsCommande(Long id, BonsCommande bonsCommande);
    void deleteBonsCommande(Long id);
}

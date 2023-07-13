package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.enums.BCStatus;
import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.model.bon.BonsCommande;

import java.util.List;
import java.util.Map;

public interface BonCommandeService {
    BonsCommande addBonsCommande(BonsCommande bonsCommande);
    BonsCommande getBonsCommande(Long id);
    List<BonsCommande> getAllBonsCommande();
    BonsCommande updateBonsCommande(Long id, BonsCommande bonsCommande);
    void deleteBonsCommande(Long id);
    Map<String,Object> getListBonCommande(String data, BCStatus bcStatus, int page, int size);

}

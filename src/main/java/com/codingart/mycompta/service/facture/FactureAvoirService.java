package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.FactureAvoirStatus;
import com.codingart.mycompta.model.facture.FactureAvoir;

import java.util.List;
import java.util.Map;

public interface FactureAvoirService {
    FactureAvoir addFactureAvoir(FactureAvoir factureAvoir);
    FactureAvoir getFactureAvoir(Long id);
    List<FactureAvoir> getAllFactureAvoir();
    Map<String,Object> getListFactureAvoir(String data, FactureAvoirStatus status, int page, int size);

    FactureAvoir updateFactureAvoir(Long id, FactureAvoir factureAvoir);
    void deleteFactureAvoir(Long id);
}

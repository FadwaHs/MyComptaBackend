package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.facture.FactureSimple;

import java.util.List;
import java.util.Map;

public interface FactureSimpleService {
    FactureSimple addFactureSimple(FactureSimple factureSimple);
    FactureSimple getFactureSimple(Long id);
    List<FactureSimple> getAllFactureSimple();
    Map<String,Object> getListFactureSimple(String data, FactureSimpleStatus status, int page, int size);
    FactureSimple updateFactureSimple(Long id, FactureSimple factureSimple);
    void deleteFactureSimple(Long id);
}

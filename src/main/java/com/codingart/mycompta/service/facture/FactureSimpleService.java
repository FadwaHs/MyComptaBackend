package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.model.facture.FactureSimple;

import java.util.List;

public interface FactureSimpleService {
    FactureSimple addFactureSimple(FactureSimple factureSimple);
    FactureSimple getFactureSimple(Long id);
    List<FactureSimple> getAllFactureSimple();
    FactureSimple updateFactureSimple(Long id, FactureSimple factureSimple);
    void deleteFactureSimple(Long id);
}

package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.model.facture.FactureAcompte;

import java.util.List;
import java.util.Map;

public interface FactureAcompteService {
    FactureAcompte addFactureAcompte(FactureAcompte factureAcompte);
    FactureAcompte getFactureAcompte(Long id);
    List<FactureAcompte> getAllFactureAcompte();
    Map<String,Object> getListFactureAcompte(String data, FactureAcompteStatus status, int page, int size);
    FactureAcompte updateFactureAcompte(Long id, FactureAcompte factureAcompte);
    void deleteFactureAcompte(Long id);
}

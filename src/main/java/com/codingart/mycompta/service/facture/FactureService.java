package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.facture.Facture;

import java.util.List;
import java.util.Map;

public interface FactureService {

    Facture addFacture(Facture facture);
    Facture getFacture(Long id);
    List<Facture> getAllFactures();
    Facture updateFacture(Long id, Facture facture);

    Map<String,Object> getListFactures(String data, int page, int size);

    void deleteFacture(Long id);
}

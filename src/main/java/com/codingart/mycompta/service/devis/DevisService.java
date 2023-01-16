package com.codingart.mycompta.service.devis;

import com.codingart.mycompta.model.devis.Devis;

import java.util.List;

public interface DevisService {
    Devis addDevis(Devis devis);
    Devis getDevis(Long id);
    List<Devis> getAllDevis();
    Devis updateDevis(Long id, Devis devis);
    void deleteDevis(Long id);
}

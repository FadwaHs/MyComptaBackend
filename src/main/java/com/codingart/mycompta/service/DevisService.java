package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Devis;

import java.util.List;

public interface DevisService {
    Devis addDevis(Devis devis);
    Devis getDevis(Long id);
    List<Devis> getAllDevis();
    Devis updateDevis(Long id, Devis devis);
    void deleteDevis(Long id);
}

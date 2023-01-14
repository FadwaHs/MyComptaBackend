package com.codingart.mycompta.service;

import com.codingart.mycompta.model.FactureAcompte;

import java.util.List;

public interface FactureAcompteService {
    FactureAcompte addFactureAcompte(FactureAcompte factureAcompte);
    FactureAcompte getFactureAcompte(Long id);
    List<FactureAcompte> getAllFactureAcompte();
    FactureAcompte updateFactureAcompte(Long id, FactureAcompte factureAcompte);
    void deleteFactureAcompte(Long id);
}

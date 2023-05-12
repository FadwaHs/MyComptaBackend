package com.codingart.mycompta.service.facturefournisseur;


import com.codingart.mycompta.model.facturefournisseur.Paiement;

import java.util.List;

public interface PaiementService {
    Paiement addPaiement(Paiement paiement);
    Paiement getPaiement(Long id);
    List<Paiement> getAllPaiement();
    Paiement updatePaiement(Long id, Paiement paiement);
    void deletePaiement(Long id);
}

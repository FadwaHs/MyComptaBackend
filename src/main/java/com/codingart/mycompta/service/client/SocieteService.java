package com.codingart.mycompta.service.client;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.opportunite.Opportunite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SocieteService {
    Societe addSociete(Societe societe);
    Societe getSociete(Long id);
    List<Societe> getAllSociete();
    Map<String,Object> getListSociete(String data,int page,int size);
    Societe updateSociete(Long id, Societe societe);
    void deleteSociete(Long id);
    List<Societe> getAllByIdAndName();

    //++
    List<Opportunite> getOpportunitesForSociete(Long id);

    List<Devis> getDevisForSociete(Long id);

    List<Facture> getAllFacturesForSociete(Long id);


}

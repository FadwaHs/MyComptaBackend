package com.codingart.mycompta.service.client;

import com.codingart.mycompta.model.client.Societe;

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

}

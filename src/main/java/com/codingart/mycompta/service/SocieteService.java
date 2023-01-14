package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Societe;

import java.util.List;

public interface SocieteService {
    Societe addSociete(Societe societe);
    Societe getSociete(Long id);
    List<Societe> getAllSociete();
    Societe updateSociete(Long id, Societe societe);
    void deleteSociete(Long id);
}

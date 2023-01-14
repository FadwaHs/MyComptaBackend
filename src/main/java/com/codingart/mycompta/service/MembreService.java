package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Membre;

import java.util.List;

public interface MembreService {
    Membre addMembre(Membre membre);
    Membre getMembre(Long id);
    List<Membre> getAllMembre();
    Membre updateMembre(Long id, Membre membre);
    void deleteMembre(Long id);
}

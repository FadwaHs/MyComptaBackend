package com.codingart.mycompta.service.auth;

import com.codingart.mycompta.model.auth.Membre;

import java.util.List;

public interface MembreService {
    Membre addMembre(Membre membre);
    Membre getMembre(Long id);
    List<Membre> getAllMembre();
    Membre updateMembre(Long id, Membre membre);
    void deleteMembre(Long id);
}

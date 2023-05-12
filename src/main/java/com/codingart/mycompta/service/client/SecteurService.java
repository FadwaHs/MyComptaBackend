package com.codingart.mycompta.service.client;


import com.codingart.mycompta.model.client.Secteur;

import java.util.List;

public interface SecteurService {

    Secteur addSecteur(Secteur secteur);
    Secteur getSecteur(Long id);
    List<Secteur> getAllSecteur();
    Secteur updateSecteur(Long id, Secteur secteur);
    void deleteSecteur(Long id);
}

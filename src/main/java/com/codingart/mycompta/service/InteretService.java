package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Interet;

import java.util.List;

public interface InteretService {
    Interet addInteret(Interet interet);
    Interet getInteret(Long id);
    List<Interet> getAllInteret();
    Interet updateInteret(Long id, Interet interet);
    void deleteInteret(Long id);
}

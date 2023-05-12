package com.codingart.mycompta.service.livraison;

import com.codingart.mycompta.model.livraison.Livraison;

import java.util.List;

public interface LivraisonService {

    Livraison addLivraison(Livraison livraison);
    Livraison getLivraison(Long id);
    List<Livraison> getAllLivraisons();
    Livraison updateLivraison(Long id, Livraison livraison);
    void deleteLivraison(Long id);
}

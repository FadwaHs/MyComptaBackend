package com.codingart.mycompta.service.livraison;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.livraison.Livraison;
import com.codingart.mycompta.repository.livraison.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LivraisonServiceImpl implements LivraisonService{

    private final LivraisonRepository livraisonRepository;
    private final String message = "Livraison not found for this id :: ";

    @Override
    public Livraison addLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    @Override
    public Livraison getLivraison(Long id) {
        return livraisonRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    @Override
    public Livraison updateLivraison(Long id, Livraison livraison) {
        livraisonRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(message+id));
        livraison.setId(id);
        return livraisonRepository.save(livraison);
    }

    @Override
    public void deleteLivraison(Long id) {
        livraisonRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        livraisonRepository.deleteById(id);

    }
}

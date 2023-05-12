package com.codingart.mycompta.service.client;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Secteur;
import com.codingart.mycompta.repository.client.SecteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SecteurServiceImpl implements SecteurService{

    private final SecteurRepository secteurRepository;
    private final String message = "Secteur not found for this id :: ";

    @Override
    public List<Secteur> getAllSecteur() {
        return secteurRepository.findAll();
    }

    @Override
    public Secteur updateSecteur( Long id, Secteur secteur) {
        secteurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        secteur.setId(id);
        return secteurRepository.save(secteur);
    }

    @Override
    public void deleteSecteur(Long id) {
        secteurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        secteurRepository.deleteById(id);
    }

    @Override
    public Secteur addSecteur(Secteur secteur) {
        return secteurRepository.save(secteur);

    }

    @Override
    public Secteur getSecteur(Long id) {
        return secteurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

}

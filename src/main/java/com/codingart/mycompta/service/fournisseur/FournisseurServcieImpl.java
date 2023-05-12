package com.codingart.mycompta.service.fournisseur;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.repository.facturefournisseur.FactureFournisseurRepository;
import com.codingart.mycompta.repository.fournisseur.FournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FournisseurServcieImpl implements FournisseurService{

    private final FournisseurRepository fournisseurRepository;
    private final FactureFournisseurRepository factureFournisseurRepository;
    private final String message = "Fournisseur not found for this id :: ";
    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();    }

    @Override
    public Fournisseur getFournisseur(Long id) {
        return fournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur) {
        fournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        fournisseur.setId(id);
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        fournisseurRepository.deleteById(id);

    }

    @Override
    public List<SimpleFournisseur> getAllSimple(Long id) {

        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            return fournisseur.getSimpleFournisseurList();
        }
        return Collections.emptyList();
    }

    @Override
    public List<AvoireFournisseur> getAllAvoire(Long id) {

        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            return fournisseur.getAvoirFournisseurList();
        }
        return Collections.emptyList();
    }

    @Override
    public List<BonsCommande> getAllBonsCommande(Long id) {

        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            return fournisseur.getBonsCommandeFournisseurList();
        }
        return Collections.emptyList();

    }

    @Override
    public List<BonLivraison> getAllBonLivraison(Long id) {
        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            return fournisseur.getBonLivraisonFournisseurList();
        }
        return Collections.emptyList();
    }
}

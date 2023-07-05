package com.codingart.mycompta.service.fournisseur;

import com.codingart.mycompta.dto.ClientDto;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
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
            fournisseur.initializeCollections();
            return fournisseur.getSimpleFournisseurList();
        }
        return Collections.emptyList();
    }

    @Override
    public List<AvoireFournisseur> getAllAvoire(Long id) {

        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            fournisseur.initializeCollections();
            return fournisseur.getAvoireFournisseurList();
        }
        return Collections.emptyList();


    }

    @Override
    public List<BonsCommande> getAllBonsCommande(Long id) {

        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            fournisseur.initializeCollections();
            return fournisseur.getBonsCommandes();
        }
        return Collections.emptyList();


    }

    @Override
    public List<BonLivraison> getAllBonLivraison(Long id) {

        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(id);
        if (fournisseurOptional.isPresent()  ){

            Fournisseur fournisseur = fournisseurOptional.get();
            fournisseur.initializeCollections();
            return fournisseur.getBonLivraisonList();
        }
        return Collections.emptyList();

    }

    @Override
    public Map<String, Object> getListFournisseurs(String data, int page, int size) {
        List<Fournisseur> fournisseurs ;
        Pageable paging = PageRequest.of(page, size);

        Page<Fournisseur> pageTuts;
        if (data == null)
            pageTuts = fournisseurRepository.findAll(paging);
        else {
            pageTuts = fournisseurRepository.findByDataContaining(data, paging);
        }
        fournisseurs = pageTuts.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("fournisseurs", fournisseurs);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public List<Fournisseur> getAllByIdAndFirstNameAndLastName() {
      return fournisseurRepository.selectAllByIdAndFirstNameAndLastName();
   }
}

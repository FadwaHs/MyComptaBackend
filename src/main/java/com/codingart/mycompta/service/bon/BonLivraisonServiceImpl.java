package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.repository.bon.BonCommandeRepository;
import com.codingart.mycompta.repository.bon.BonLivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BonLivraisonServiceImpl implements BonLivraisonService{

    private final BonLivraisonRepository bonLivraisonRepository;
    private final String message = "BonLivraison not found for this id :: ";
    private  static int count =0;
    @Override
    public BonLivraison addBonLivraison(BonLivraison bonLivraison) {

        bonLivraison.setDate_creation(new Date());
        // get the largest code value from the database
       String largestCode = bonLivraisonRepository.findLargestCode();
        if (largestCode == null) {
            count = 1;
        } else {
            count = Integer.parseInt(largestCode.substring(11)) + 1;
        }

        String code = String.format("N°F_DEL-%05d", count);
        bonLivraison.setNumero_interne(code);

        return bonLivraisonRepository.save(bonLivraison);
    }

    @Override
    public BonLivraison getBonLivraison(Long id) {
        return bonLivraisonRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<BonLivraison> getAllBonLivraison() {
        return bonLivraisonRepository.findAll();
    }

    @Override
    public BonLivraison updateBonLivraison(Long id, BonLivraison bonLivraison) {
        bonLivraisonRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        bonLivraison.setId(id);
        return bonLivraisonRepository.save(bonLivraison);     }

    @Override
    public void deleteBonLivraison(Long id) {
        bonLivraisonRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        bonLivraisonRepository.deleteById(id);

    }
}

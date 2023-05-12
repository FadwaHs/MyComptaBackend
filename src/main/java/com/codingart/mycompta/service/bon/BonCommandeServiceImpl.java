package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.repository.bon.BonCommandeRepository;
import com.codingart.mycompta.repository.facturefournisseur.AvoirFournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BonCommandeServiceImpl implements BonCommandeService {

    private final BonCommandeRepository bonCommandeRepository;
    private final String message = "BonsCommande not found for this id :: ";
    private  static int count =0;
    @Override
    public BonsCommande addBonsCommande(BonsCommande bonsCommande) {

        bonsCommande.setDate_creation(new Date());
        // get the largest code value from the database
        String largestCode = bonCommandeRepository.findLargestCode();
        int count = Integer.parseInt(largestCode.substring(4)) + 1;
        String code = String.format("N°F_ORD-%05d", count);
        bonsCommande.setNumero_interne(code);

        return bonCommandeRepository.save(bonsCommande);
    }

    @Override
    public BonsCommande getBonsCommande(Long id) {
        return bonCommandeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<BonsCommande> getAllBonsCommande() {
        return bonCommandeRepository.findAll();
    }

    @Override
    public BonsCommande updateBonsCommande(Long id, BonsCommande bonsCommande) {
        bonCommandeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        bonsCommande.setId(id);
        return bonCommandeRepository.save(bonsCommande);
    }

    @Override
    public void deleteBonsCommande(Long id) {
        bonCommandeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        bonCommandeRepository.deleteById(id);


    }
}

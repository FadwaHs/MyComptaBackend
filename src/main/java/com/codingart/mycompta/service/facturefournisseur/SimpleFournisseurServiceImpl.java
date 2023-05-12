package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
import com.codingart.mycompta.repository.facturefournisseur.SimpleFournisseurRepository;
import com.codingart.mycompta.util.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SimpleFournisseurServiceImpl implements SimpleFournisseurService{

    private final SimpleFournisseurRepository simpleFournisseurRepository;
    private final String message = "SimpleFournisseur not found for this id :: ";
    private  static int count =0;


    @Override
    public SimpleFournisseur addSimpleFournisseur(SimpleFournisseur simpleFournisseur) {

        simpleFournisseur.setDate_creation(new Date());
        // get the largest code value from the database
        String largestCode = simpleFournisseurRepository.findLargestCode();
        int count = Integer.parseInt(largestCode.substring(4)) + 1;
        String code = String.format("F_INV-%05d", count);
        simpleFournisseur.setNumero_interne(code);

        return simpleFournisseurRepository.save(simpleFournisseur);
    }

    @Override
    public SimpleFournisseur getSimpleFournisseur(Long id) {
        return simpleFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<SimpleFournisseur> getAllSimpleFournisseur() {
        return simpleFournisseurRepository.findAll();
    }

    @Override
    public SimpleFournisseur updateSimpleFournisseur(Long id, SimpleFournisseur simpleFournisseur) {
        simpleFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        simpleFournisseur.setId(id);
        return simpleFournisseurRepository.save(simpleFournisseur);    }

    @Override
    public void deleteSimpleFournisseur(Long id) {
        simpleFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        simpleFournisseurRepository.deleteById(id);

    }
}

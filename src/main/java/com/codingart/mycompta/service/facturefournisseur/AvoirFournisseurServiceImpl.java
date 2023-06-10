package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.repository.facturefournisseur.AvoirFournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AvoirFournisseurServiceImpl implements AvoirFournisseurService{

    private final AvoirFournisseurRepository avoirFournisseurRepository;
    private final String message = "AvoirFournisseur not found for this id :: ";
    private  static int count =0;


    @Override
    public AvoireFournisseur addAvoireFournisseur(AvoireFournisseur avoirFournisseur) {

        avoirFournisseur.setDate_creation(new Date());
        // get the largest code value from the database
        String largestCode = avoirFournisseurRepository.findLargestCode();
        int count = Integer.parseInt(largestCode.substring(4)) + 1;
        String code = String.format("F_AVR-%05d", count);
        avoirFournisseur.setNumero_interne(code);

        return avoirFournisseurRepository.save(avoirFournisseur);
    }

    @Override
    public AvoireFournisseur getAvoireFournisseur(Long id) {
        return avoirFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<AvoireFournisseur> getAllAvoireFournisseur() {
        return avoirFournisseurRepository.findAll();
    }

    @Override
    public AvoireFournisseur updateAvoireFournisseur(Long id, AvoireFournisseur avoirFournisseur) {

        avoirFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        avoirFournisseur.setId(id);
        return avoirFournisseurRepository.save(avoirFournisseur);
}

    @Override
    public void deleteAvoireFournisseur(Long id) {
        avoirFournisseurRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        avoirFournisseurRepository.deleteById(id);
    }

    @Override
    public Map<String, Object> getListAvoirFournsseur(String data, AvoireFournisseurStatus status, int page, int size) {
        List<AvoireFournisseur> avoireFournisseurList ;
        Pageable paging = PageRequest.of(page, size);

        Page<AvoireFournisseur> pageTuts;
        if (data == null && status == null) {
            pageTuts = avoirFournisseurRepository.findAll(paging);
        }
        else if(data != null && status !=null){
            pageTuts = avoirFournisseurRepository.findByDataContainingWithStatus(data, status, paging);
        } else if (data != null) {
            pageTuts = avoirFournisseurRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = avoirFournisseurRepository.findSimpleFounisseurByStatus(status, paging);
        }

        avoireFournisseurList = pageTuts.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("avoirsfournisseur", avoireFournisseurList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}



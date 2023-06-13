package com.codingart.mycompta.service.facturefournisseur;

import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
import com.codingart.mycompta.repository.facturefournisseur.SimpleFournisseurRepository;
import com.codingart.mycompta.util.FormatService;
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
public class SimpleFournisseurServiceImpl implements SimpleFournisseurService{

    private final SimpleFournisseurRepository simpleFournisseurRepository;
    private final String message = "SimpleFournisseur not found for this id :: ";
    private  static int count =0;


    @Override
    public SimpleFournisseur addSimpleFournisseur(SimpleFournisseur simpleFournisseur) {

        simpleFournisseur.setDate_creation(new Date());
        // get the largest code value from the database
        String largestCode = simpleFournisseurRepository.findLargestCode();
        count = Integer.parseInt(largestCode.substring(4)) + 1;
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

    @Override
    public Map<String, Object> getListSimpleFournsseur(String data, SimpleFournisseurStatus status, int page, int size) {
        List<SimpleFournisseur> simpleFournisseurList ;
        Pageable paging = PageRequest.of(page, size);

        Page<SimpleFournisseur> pageTuts;
        if (data == null && status == null) {
            pageTuts = simpleFournisseurRepository.findAll(paging);
        }
        else if(data != null && status !=null){
            pageTuts = simpleFournisseurRepository.findByDataContainingWithStatus(data, status, paging);
        } else if (data != null) {
            pageTuts = simpleFournisseurRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = simpleFournisseurRepository.findSimpleFounisseurByStatus(status, paging);
        }

        simpleFournisseurList = pageTuts.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("facturesfournisseur", simpleFournisseurList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}


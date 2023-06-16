package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.repository.bon.BonCommandeRepository;
import com.codingart.mycompta.repository.bon.BonLivraisonRepository;
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

    @Override
    public Map<String, Object> getListBonLivraison(String data, BLStatus blStatus, int page, int size) {

        List<BonLivraison> bonLivraisonList ;
        Pageable paging = PageRequest.of(page, size);

        Page<BonLivraison> pageTuts;
        if (data == null && blStatus == null) {
            pageTuts = bonLivraisonRepository.findAll(paging);
        }
        else if(data != null && blStatus !=null){
            pageTuts = bonLivraisonRepository.findByDataContainingWithStatus(data, blStatus, paging);
        } else if (data != null) {
            pageTuts = bonLivraisonRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = bonLivraisonRepository.findBonLivraisonByBlStatus(blStatus, paging);
        }
        bonLivraisonList = pageTuts.getContent();
        Map<String, Object> response =  new HashMap<>();
        response.put("bonlivraison", bonLivraisonList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}

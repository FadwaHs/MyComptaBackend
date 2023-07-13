package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.enums.BCStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.repository.bon.BonCommandeRepository;
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
public class BonCommandeServiceImpl implements BonCommandeService {

    private final BonCommandeRepository bonCommandeRepository;
    private final String message = "BonsCommande not found for this id :: ";
    private  static int count =0;
    @Override
    public BonsCommande addBonsCommande(BonsCommande bonsCommande) {

        bonsCommande.setDate_creation(new Date());
        // get the largest code value from the database
        String largestCode = bonCommandeRepository.findLargestCode();
        if (largestCode == null) {
            count = 1;
        } else {
            count = Integer.parseInt(largestCode.substring(11)) + 1;
        }
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

    @Override
    public Map<String, Object> getListBonCommande(String data, BCStatus bcStatus, int page, int size) {
        List<BonsCommande> bonsCommandeList ;
        Pageable paging = PageRequest.of(page, size);

        Page<BonsCommande> pageTuts;
        if (data == null && bcStatus == null) {
            pageTuts = bonCommandeRepository.findAll(paging);
        }
        else if(data != null && bcStatus !=null){
            pageTuts = bonCommandeRepository.findByDataContainingWithStatus(data, bcStatus, paging);
        } else if (data != null) {
            pageTuts = bonCommandeRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = bonCommandeRepository.findBonCommandeByBcStatus(bcStatus, paging);
        }
        bonsCommandeList = pageTuts.getContent();
        Map<String, Object> response =  new HashMap<>();
        response.put("bonCommande", bonsCommandeList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}

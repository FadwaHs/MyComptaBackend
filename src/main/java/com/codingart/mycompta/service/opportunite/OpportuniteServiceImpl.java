package com.codingart.mycompta.service.opportunite;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.repository.devis.DevisRepository;
import com.codingart.mycompta.repository.opportunite.OpportuniteRepository;
import com.codingart.mycompta.util.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OpportuniteServiceImpl  implements OpportuniteService {

    private final OpportuniteRepository opportuniteRepository;
    private final FormatService formatService;
    private  static int count =0;
    private final String message = "Opp not found for this id :: ";

    @Override
    public Opportunite addOpportunite(Opportunite opportunite) {
        // get the largest code value from the database
        String largestCode = opportuniteRepository.findLargestCode();
        int count = Integer.parseInt(largestCode.substring(4)) + 1;
        String code = String.format("OPP-%05d", count);
        opportunite.setCode(code);
        return opportuniteRepository.save(opportunite);
    }

    @Override
    public Opportunite getOpportunite(Long id) {
        return opportuniteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Opportunite> getAllOpportunites() {
         return opportuniteRepository.findAll();
    }

    @Override
    public Opportunite updateOpportunite(Long id, Opportunite opportunite) {

        opportuniteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(message+id));
        opportunite.setId(id);
        return opportuniteRepository.save(opportunite);
    }

    @Override
    public void deleteOpportunite(Long id) {
        opportuniteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        opportuniteRepository.deleteById(id);
    }

    @Override
    public List<Devis> getDevisForOpportunite(Long id) {

        Optional<Opportunite> optionalOpportunite = opportuniteRepository.findById(id);
        if (optionalOpportunite.isPresent()  ){

            Opportunite opportunite = optionalOpportunite.get();
            opportunite.initializeCollections();
            return opportunite.getDevis();
        }
        return Collections.emptyList();
    }
}

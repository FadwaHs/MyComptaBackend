package com.codingart.mycompta.service.opportunite;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.opportunite.Etape;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.repository.opportunite.EtapeRepository;
import com.codingart.mycompta.repository.opportunite.OpportuniteRepository;
import com.codingart.mycompta.util.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtapeServiceImpl implements  EtapeService{

    private final EtapeRepository etapeRepository;
    private final String message = "Etape not found for this id :: ";


    @Override
    public Etape addEtape(Etape etape) {

        return etapeRepository.save(etape);
    }

    @Override
    public Etape getEtape(Long id) {
        return etapeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Etape> getAllEtape() {
       return  etapeRepository.findAll();
    }

    @Override
    public Etape updateEtape(Long id, Etape etape) {
        etapeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(message+id));
        etape.setId(id);
        return etapeRepository.save(etape);
    }

    @Override
    public void deleteEtape(Long id) {
        etapeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        etapeRepository.deleteById(id);
    }

    @Override
    public List<Opportunite> getOpportuniteForEtape(Long id) {
        Optional<Etape> etapeOptional = etapeRepository.findById(id);
        if (etapeOptional.isPresent()  ){
            Etape etape = etapeOptional.get();
            etape.initializeCollections();
            return etape.getOpportuniteList();
        }
        return Collections.emptyList();
    }
}

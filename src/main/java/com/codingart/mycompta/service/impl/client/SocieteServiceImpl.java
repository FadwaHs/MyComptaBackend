package com.codingart.mycompta.service.impl.client;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.repository.client.SocieteRepository;
import com.codingart.mycompta.service.client.SocieteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocieteServiceImpl implements SocieteService {

    private final SocieteRepository societeRepository;
    private final String message = "Societe not found for this id :: ";


    @Override
    public Societe addSociete(Societe societe) {
        return societeRepository.save(societe);

    }

    @Override
    public Societe getSociete(Long id) {
        return societeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Societe> getAllSociete() {
        return societeRepository.findAll();
    }

    @Override
    public Societe updateSociete( Long id, Societe societe) {
        societeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        societe.setId(id);
        return societeRepository.save(societe);
    }

    @Override
    public void deleteSociete(Long id) {
        societeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        societeRepository.deleteById(id);
    }

}

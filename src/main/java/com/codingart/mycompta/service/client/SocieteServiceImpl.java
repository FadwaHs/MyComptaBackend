package com.codingart.mycompta.service.client;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.repository.client.SocieteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Map<String, Object> getListSociete(String data, int page, int size) {
        List<Societe> societes ;
        Pageable paging = PageRequest.of(page, size);

        Page<Societe> pageTuts;
        if (data == null)
            pageTuts = societeRepository.findAll(paging);
        else {
            pageTuts = societeRepository.findByDataContaining(data, paging);
        }
        societes = pageTuts.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("societes", societes);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
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

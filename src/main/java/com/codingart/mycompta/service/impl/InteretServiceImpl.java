package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.Interet;
import com.codingart.mycompta.repository.InteretRepository;
import com.codingart.mycompta.service.InteretService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteretServiceImpl implements InteretService {

    private final InteretRepository interetRepository;
    private final String message = "Interet not found for this id :: ";


    @Override
    public Interet addInteret(Interet interet) {
        return interetRepository.save(interet);

    }

    @Override
    public Interet getInteret(Long id) {
        return interetRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Interet> getAllInteret() {
        return interetRepository.findAll();
    }

    @Override
    public Interet updateInteret( Long id, Interet interet) {
        interetRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        interet.setId(id);
        return interetRepository.save(interet);
    }

    @Override
    public void deleteInteret(Long id) {
        interetRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        interetRepository.deleteById(id);
    }

}

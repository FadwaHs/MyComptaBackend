package com.codingart.mycompta.service.impl.auth;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.auth.Membre;
import com.codingart.mycompta.repository.auth.MembreRepository;
import com.codingart.mycompta.service.auth.MembreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;
    private final String message = "Membre not found for this id :: ";


    @Override
    public Membre addMembre(Membre membre) {
        return membreRepository.save(membre);

    }

    @Override
    public Membre getMembre(Long id) {
        return membreRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Membre> getAllMembre() {
        return membreRepository.findAll();
    }

    @Override
    public Membre updateMembre( Long id, Membre membre) {
        membreRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        membre.setId(id);
        return membreRepository.save(membre);
    }

    @Override
    public void deleteMembre(Long id) {
        membreRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        membreRepository.deleteById(id);
    }

}

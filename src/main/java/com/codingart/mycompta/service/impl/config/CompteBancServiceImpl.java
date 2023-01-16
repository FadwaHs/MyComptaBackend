package com.codingart.mycompta.service.impl.config;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.CompteBanc;
import com.codingart.mycompta.repository.config.CompteBancRepository;
import com.codingart.mycompta.service.config.CompteBancService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompteBancServiceImpl implements CompteBancService {

    private final CompteBancRepository compteBancRepository;
    private final String message = "CompteBanc not found for this id :: ";


    @Override
    public CompteBanc addCompteBanc(CompteBanc compteBanc) {
        return compteBancRepository.save(compteBanc);

    }

    @Override
    public CompteBanc getCompteBanc(Long id) {
        return compteBancRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<CompteBanc> getAllCompteBanc() {
        return compteBancRepository.findAll();
    }

    @Override
    public CompteBanc updateCompteBanc( Long id, CompteBanc compteBanc) {
        compteBancRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        compteBanc.setId(id);
        return compteBancRepository.save(compteBanc);
    }

    @Override
    public void deleteCompteBanc(Long id) {
        compteBancRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        compteBancRepository.deleteById(id);
    }

}

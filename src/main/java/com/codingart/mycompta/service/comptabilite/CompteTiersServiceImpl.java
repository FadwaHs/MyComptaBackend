package com.codingart.mycompta.service.comptabilite;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.comptabilite.CompteTiers;
import com.codingart.mycompta.repository.comptabilite.CompteTiersRepository;
import com.codingart.mycompta.repository.opportunite.OpportuniteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompteTiersServiceImpl  implements  CompteTiersService {


    private final CompteTiersRepository compteTiersRepository;
    private final String message = "compte not found for this id :: ";
    @Override
    public CompteTiers addCompteTiers(CompteTiers compteTiers) {
        return compteTiersRepository.save(compteTiers);
    }

    @Override
    public CompteTiers getCompteTiers(Long id) {
        return compteTiersRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<CompteTiers> getAllCompteTiers() {
        return compteTiersRepository.findAll();
    }

    @Override
    public CompteTiers updateCompteTiers(Long id, CompteTiers compteTiers) {

        compteTiersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(message+id));
        compteTiers.setId(id);
        return compteTiersRepository.save(compteTiers);

    }

    @Override
    public void deleteCompteTiers(Long id) {
        compteTiersRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        compteTiersRepository.deleteById(id);
    }
}

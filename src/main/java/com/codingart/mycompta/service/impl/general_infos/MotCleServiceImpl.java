package com.codingart.mycompta.service.impl.general_infos;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.repository.general_infos.MotCleRepository;
import com.codingart.mycompta.service.general_infos.MotCleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotCleServiceImpl implements MotCleService {

    private final MotCleRepository motCleRepository;
    private final String message = "MotCle not found for this id :: ";


    @Override
    public MotCle addMotCle(MotCle motCle) {
        return motCleRepository.save(motCle);

    }

    @Override
    public MotCle getMotCle(Long id) {
        return motCleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<MotCle> getAllMotCle() {
        return motCleRepository.findAll();
    }

    @Override
    public MotCle updateMotCle( Long id, MotCle motCle) {
        motCleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        motCle.setId(id);
        return motCleRepository.save(motCle);
    }

    @Override
    public void deleteMotCle(Long id) {
        motCleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        motCleRepository.deleteById(id);
    }

}

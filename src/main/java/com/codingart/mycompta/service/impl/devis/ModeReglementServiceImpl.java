package com.codingart.mycompta.service.impl.devis;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.repository.devis.ModeReglementRepository;
import com.codingart.mycompta.service.devis.ModeReglementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeReglementServiceImpl implements ModeReglementService {

    private final ModeReglementRepository modeReglementRepository;
    private final String message = "ModeReglement not found for this id :: ";


    @Override
    public ModeReglement addModeReglement(ModeReglement modeReglement) {
        return modeReglementRepository.save(modeReglement);

    }

    @Override
    public ModeReglement getModeReglement(Long id) {
        return modeReglementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ModeReglement> getAllModeReglement() {
        return modeReglementRepository.findAll();
    }

    @Override
    public ModeReglement updateModeReglement( Long id, ModeReglement modeReglement) {
        modeReglementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        modeReglement.setId(id);
        return modeReglementRepository.save(modeReglement);
    }

    @Override
    public void deleteModeReglement(Long id) {
        modeReglementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        modeReglementRepository.deleteById(id);
    }

}

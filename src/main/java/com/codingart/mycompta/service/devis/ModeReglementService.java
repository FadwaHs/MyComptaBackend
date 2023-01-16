package com.codingart.mycompta.service.devis;

import com.codingart.mycompta.model.devis.ModeReglement;

import java.util.List;

public interface ModeReglementService {
    ModeReglement addModeReglement(ModeReglement modeReglement);
    ModeReglement getModeReglement(Long id);
    List<ModeReglement> getAllModeReglement();
    ModeReglement updateModeReglement(Long id, ModeReglement modeReglement);
    void deleteModeReglement(Long id);
}

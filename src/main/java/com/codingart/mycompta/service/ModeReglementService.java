package com.codingart.mycompta.service;

import com.codingart.mycompta.model.ModeReglement;

import java.util.List;

public interface ModeReglementService {
    ModeReglement addModeReglement(ModeReglement modeReglement);
    ModeReglement getModeReglement(Long id);
    List<ModeReglement> getAllModeReglement();
    ModeReglement updateModeReglement(Long id, ModeReglement modeReglement);
    void deleteModeReglement(Long id);
}

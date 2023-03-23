package com.codingart.mycompta.service.devis;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.enums.DevisStatus;

import java.util.List;
import java.util.Map;

public interface DevisService {
    Devis addDevis(Devis devis);
    DevisDto getDevis(Long id);
    List<Devis> getAllDevis();
    Map<String,Object> getListDevis(String data, DevisStatus status, int page, int size);
    Devis updateDevis(Long id, Devis devis);
    void deleteDevis(Long id);
}

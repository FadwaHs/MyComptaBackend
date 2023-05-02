package com.codingart.mycompta.service.opportunite;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Opportunite;

import java.util.List;
import java.util.Map;

public interface OpportuniteService {

    Opportunite addOpportunite(Opportunite opportunite);
    Opportunite getOpportunite(Long id);
    List<Opportunite> getAllOpportunites();
    Opportunite updateOpportunite(Long id, Opportunite opportunite);
    void deleteOpportunite(Long id);

}

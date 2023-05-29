package com.codingart.mycompta.service.opportunite;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.opportunite.Etape;
import com.codingart.mycompta.model.opportunite.Opportunite;

import java.util.List;

public interface EtapeService {

    Etape addEtape(Etape etape);
    Etape getEtape(Long id);
    List<Etape> getAllEtape();
    Etape updateEtape(Long id, Etape etape);
    void deleteEtape(Long id);

    List<Opportunite> getOpportuniteForEtape(Long id);
}

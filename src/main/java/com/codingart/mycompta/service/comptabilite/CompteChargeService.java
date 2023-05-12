package com.codingart.mycompta.service.comptabilite;

import com.codingart.mycompta.model.comptabilite.CompteCharge;
import com.codingart.mycompta.model.comptabilite.CompteTiers;

import java.util.List;

public interface CompteChargeService {

    CompteCharge addCompteCharge(CompteCharge compteCharge);
    CompteCharge getCompteCharge(Long id);
    List<CompteCharge> getAllCompteCharge();
    CompteCharge updateCompteCharge(Long id, CompteCharge compteCharge);
    void deleteCompteCharge(Long id);
}

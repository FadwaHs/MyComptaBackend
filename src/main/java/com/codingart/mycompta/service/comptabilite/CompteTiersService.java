package com.codingart.mycompta.service.comptabilite;


import com.codingart.mycompta.model.comptabilite.CompteTiers;

import java.util.List;

public interface CompteTiersService {

    CompteTiers addCompteTiers(CompteTiers compteTiers);
    CompteTiers getCompteTiers(Long id);
    List<CompteTiers> getAllCompteTiers();
    CompteTiers updateCompteTiers(Long id, CompteTiers compteTiers);
    void deleteCompteTiers(Long id);
}

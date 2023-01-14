package com.codingart.mycompta.service;

import com.codingart.mycompta.model.ConfigAcompte;

import java.util.List;

public interface ConfigAcompteService {

    ConfigAcompte addConfigAcompte(ConfigAcompte configAcompte);
    ConfigAcompte getConfigAcompte(Long id);
    List<ConfigAcompte> getAllConfigAcompte();
    ConfigAcompte updateConfigAcompte(Long id, ConfigAcompte configAcompte);
    void deleteConfigAcompte(Long id);
}

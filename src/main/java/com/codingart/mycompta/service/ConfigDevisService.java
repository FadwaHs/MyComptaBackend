package com.codingart.mycompta.service;

import com.codingart.mycompta.model.ConfigDevis;

import java.util.List;

public interface ConfigDevisService {
    ConfigDevis addConfigDevis(ConfigDevis configDevis);
    ConfigDevis getConfigDevis(Long id);
    List<ConfigDevis> getAllConfigDevis();
    ConfigDevis updateConfigDevis(Long id, ConfigDevis configDevis);
    void deleteConfigDevis(Long id);
}

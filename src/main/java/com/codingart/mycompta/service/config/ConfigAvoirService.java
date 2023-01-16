package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.ConfigAvoir;

import java.util.List;

public interface ConfigAvoirService {
    ConfigAvoir addConfigAvoir(ConfigAvoir configAvoir);
    ConfigAvoir getConfigAvoir(Long id);
    List<ConfigAvoir> getAllConfigAvoir();
    ConfigAvoir updateConfigAvoir(Long id, ConfigAvoir configAvoir);
    void deleteConfigAvoir(Long id);
}

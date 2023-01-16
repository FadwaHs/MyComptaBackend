package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.Defaults;

import java.util.List;

public interface DefaultsService {
    Defaults addDefaults(Defaults defaults);
    Defaults getDefaults(Long id);
    List<Defaults> getAllDefaults();
    Defaults updateDefaults(Long id, Defaults defaults);
    void deleteDefaults(Long id);
}

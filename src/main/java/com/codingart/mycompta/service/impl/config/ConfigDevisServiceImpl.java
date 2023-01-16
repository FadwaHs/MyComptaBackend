package com.codingart.mycompta.service.impl.config;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.ConfigDevis;
import com.codingart.mycompta.repository.config.ConfigDevisRepository;
import com.codingart.mycompta.service.config.ConfigDevisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigDevisServiceImpl implements ConfigDevisService {

    private final ConfigDevisRepository configDevisRepository;
    private final String message = "ConfigDevis not found for this id :: ";


    @Override
    public ConfigDevis addConfigDevis(ConfigDevis configDevis) {
        return configDevisRepository.save(configDevis);

    }

    @Override
    public ConfigDevis getConfigDevis(Long id) {
        return configDevisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ConfigDevis> getAllConfigDevis() {
        return configDevisRepository.findAll();
    }

    @Override
    public ConfigDevis updateConfigDevis( Long id, ConfigDevis configDevis) {
        configDevisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configDevis.setId(id);
        return configDevisRepository.save(configDevis);
    }

    @Override
    public void deleteConfigDevis(Long id) {
        configDevisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configDevisRepository.deleteById(id);
    }

}

package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.ConfigAvoir;
import com.codingart.mycompta.repository.ConfigAvoirRepository;
import com.codingart.mycompta.service.ConfigAvoirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigAvoirServiceImpl implements ConfigAvoirService {

    private final ConfigAvoirRepository configAvoirRepository;
    private final String message = "ConfigAvoir not found for this id :: ";


    @Override
    public ConfigAvoir addConfigAvoir(ConfigAvoir configAvoir) {
        return configAvoirRepository.save(configAvoir);

    }

    @Override
    public ConfigAvoir getConfigAvoir(Long id) {
        return configAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ConfigAvoir> getAllConfigAvoir() {
        return configAvoirRepository.findAll();
    }

    @Override
    public ConfigAvoir updateConfigAvoir( Long id, ConfigAvoir configAvoir) {
        configAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configAvoir.setId(id);
        return configAvoirRepository.save(configAvoir);
    }

    @Override
    public void deleteConfigAvoir(Long id) {
        configAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configAvoirRepository.deleteById(id);
    }

}

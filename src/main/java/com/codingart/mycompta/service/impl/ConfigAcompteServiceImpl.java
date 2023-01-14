package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.ConfigAcompte;
import com.codingart.mycompta.repository.ConfigAcompteRepository;
import com.codingart.mycompta.service.ConfigAcompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigAcompteServiceImpl implements ConfigAcompteService {

    private final ConfigAcompteRepository configAcompteRepository;
    private final String message = "ConfigAcompte not found for this id :: ";


    @Override
    public ConfigAcompte addConfigAcompte(ConfigAcompte configAcompte) {
        return configAcompteRepository.save(configAcompte);

    }

    @Override
    public ConfigAcompte getConfigAcompte(Long id) {
        return configAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ConfigAcompte> getAllConfigAcompte() {
        return configAcompteRepository.findAll();
    }

    @Override
    public ConfigAcompte updateConfigAcompte( Long id, ConfigAcompte configAcompte) {
        configAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configAcompte.setId(id);
        return configAcompteRepository.save(configAcompte);
    }

    @Override
    public void deleteConfigAcompte(Long id) {
        configAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configAcompteRepository.deleteById(id);
    }

}

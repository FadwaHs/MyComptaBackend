package com.codingart.mycompta.service.impl.config;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.ConfigFacture;
import com.codingart.mycompta.repository.config.ConfigFactureRepository;
import com.codingart.mycompta.service.config.ConfigFactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigFactureServiceImpl implements ConfigFactureService {

    private final ConfigFactureRepository configFactureRepository;
    private final String message = "ConfigFacture not found for this id :: ";


    @Override
    public ConfigFacture addConfigFacture(ConfigFacture configFacture) {
        return configFactureRepository.save(configFacture);

    }

    @Override
    public ConfigFacture getConfigFacture(Long id) {
        return configFactureRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ConfigFacture> getAllConfigFacture() {
        return configFactureRepository.findAll();
    }

    @Override
    public ConfigFacture updateConfigFacture( Long id, ConfigFacture configFacture) {
        configFactureRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configFacture.setId(id);
        return configFactureRepository.save(configFacture);
    }

    @Override
    public void deleteConfigFacture(Long id) {
        configFactureRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configFactureRepository.deleteById(id);
    }

}

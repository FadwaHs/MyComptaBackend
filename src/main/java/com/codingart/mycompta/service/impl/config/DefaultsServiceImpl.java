package com.codingart.mycompta.service.impl.config;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.Defaults;
import com.codingart.mycompta.repository.config.DefaultsRepository;
import com.codingart.mycompta.service.config.DefaultsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultsServiceImpl implements DefaultsService {

    private final DefaultsRepository defaultsRepository;
    private final String message = "Defaults not found for this id :: ";


    @Override
    public Defaults addDefaults(Defaults defaults) {
        return defaultsRepository.save(defaults);

    }

    @Override
    public Defaults getDefaults(Long id) {
        return defaultsRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Defaults> getAllDefaults() {
        return defaultsRepository.findAll();
    }

    @Override
    public Defaults updateDefaults( Long id, Defaults defaults) {
        defaultsRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        defaults.setId(id);
        return defaultsRepository.save(defaults);
    }

    @Override
    public void deleteDefaults(Long id) {
        defaultsRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        defaultsRepository.deleteById(id);
    }

}

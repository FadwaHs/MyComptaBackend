package com.codingart.mycompta.service.impl.environment;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.repository.environment.EnvironmentRepository;
import com.codingart.mycompta.service.environment.EnvironmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvironmentServiceImpl implements EnvironmentService {

    private final EnvironmentRepository environmentRepository;
    private final String message = "Environment not found for this id :: ";


    @Override
    public Environment addEnvironment(Environment environment) {
        return environmentRepository.save(environment);

    }

    @Override
    public Environment getEnvironment(Long id) {
        return environmentRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Environment> getAllEnvironment() {
        return environmentRepository.findAll();
    }

    @Override
    public Environment updateEnvironment( Long id, Environment environment) {
        environmentRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        environment.setId(id);
        return environmentRepository.save(environment);
    }

    @Override
    public void deleteEnvironment(Long id) {
        environmentRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        environmentRepository.deleteById(id);
    }

}

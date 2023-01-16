package com.codingart.mycompta.service.environment;

import com.codingart.mycompta.model.environment.Environment;

import java.util.List;

public interface EnvironmentService {
    Environment addEnvironment(Environment environment);
    Environment getEnvironment(Long id);
    List<Environment> getAllEnvironment();
    Environment updateEnvironment(Long id, Environment environment);
    void deleteEnvironment(Long id);
}

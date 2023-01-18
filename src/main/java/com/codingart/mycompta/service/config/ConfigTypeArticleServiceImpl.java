package com.codingart.mycompta.service.config;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.ConfigTypeArticle;
import com.codingart.mycompta.repository.config.ConfigTypeArticleRepository;
import com.codingart.mycompta.service.config.ConfigTypeArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigTypeArticleServiceImpl implements ConfigTypeArticleService {

    private final ConfigTypeArticleRepository configTypeArticleRepository;
    private final String message = "ConfigTypeArticle not found for this id :: ";


    @Override
    public ConfigTypeArticle addConfigTypeArticle(ConfigTypeArticle configTypeArticle) {
        return configTypeArticleRepository.save(configTypeArticle);

    }

    @Override
    public ConfigTypeArticle getConfigTypeArticle(Long id) {
        return configTypeArticleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ConfigTypeArticle> getAllConfigTypeArticle() {
        return configTypeArticleRepository.findAll();
    }

    @Override
    public ConfigTypeArticle updateConfigTypeArticle( Long id, ConfigTypeArticle configTypeArticle) {
        configTypeArticleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configTypeArticle.setId(id);
        return configTypeArticleRepository.save(configTypeArticle);
    }

    @Override
    public void deleteConfigTypeArticle(Long id) {
        configTypeArticleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        configTypeArticleRepository.deleteById(id);
    }

}

package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.ConfigTypeArticle;

import java.util.List;

public interface ConfigTypeArticleService {
    ConfigTypeArticle addConfigTypeArticle(ConfigTypeArticle configTypeArticle);
    ConfigTypeArticle getConfigTypeArticle(Long id);
    List<ConfigTypeArticle> getAllConfigTypeArticle();
    ConfigTypeArticle updateConfigTypeArticle(Long id, ConfigTypeArticle configTypeArticle);
    void deleteConfigTypeArticle(Long id);
}

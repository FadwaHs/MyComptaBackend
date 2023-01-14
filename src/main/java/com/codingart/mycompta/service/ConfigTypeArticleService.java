package com.codingart.mycompta.service;

import com.codingart.mycompta.model.ConfigTypeArticle;

import java.util.List;

public interface ConfigTypeArticleService {
    ConfigTypeArticle addConfigTypeArticle(ConfigTypeArticle configTypeArticle);
    ConfigTypeArticle getConfigTypeArticle(Long id);
    List<ConfigTypeArticle> getAllConfigTypeArticle();
    ConfigTypeArticle updateConfigTypeArticle(Long id, ConfigTypeArticle configTypeArticle);
    void deleteConfigTypeArticle(Long id);
}

package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.Theme;

import java.util.List;

public interface ThemeService {
    Theme addTheme(Theme theme);
    Theme getTheme(Long id);
    List<Theme> getAllTheme();
    Theme updateTheme(Long id, Theme theme);
    void deleteTheme(Long id);
}

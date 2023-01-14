package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Theme;

import java.util.List;

public interface ThemeService {
    Theme addTheme(Theme theme);
    Theme getTheme(Long id);
    List<Theme> getAllTheme();
    Theme updateTheme(Long id, Theme theme);
    void deleteTheme(Long id);
}

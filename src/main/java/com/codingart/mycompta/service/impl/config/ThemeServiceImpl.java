package com.codingart.mycompta.service.impl.config;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.config.Theme;
import com.codingart.mycompta.repository.config.ThemeRepository;
import com.codingart.mycompta.service.config.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeRepository;
    private final String message = "Theme not found for this id :: ";


    @Override
    public Theme addTheme(Theme theme) {
        return themeRepository.save(theme);

    }

    @Override
    public Theme getTheme(Long id) {
        return themeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Theme> getAllTheme() {
        return themeRepository.findAll();
    }

    @Override
    public Theme updateTheme( Long id, Theme theme) {
        themeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        theme.setId(id);
        return themeRepository.save(theme);
    }

    @Override
    public void deleteTheme(Long id) {
        themeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        themeRepository.deleteById(id);
    }

}

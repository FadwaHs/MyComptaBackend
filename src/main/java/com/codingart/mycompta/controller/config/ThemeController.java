package com.codingart.mycompta.controller.config;

import com.codingart.mycompta.model.config.Theme;
import com.codingart.mycompta.service.config.ThemeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping("{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable Long id){
        return new ResponseEntity<>(themeService.getTheme(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Theme>> getAllTheme(){
        return new ResponseEntity<>(themeService.getAllTheme(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Theme> createTheme(@Valid @RequestBody Theme theme){
        return new ResponseEntity<>(themeService.addTheme(theme), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Theme> updateTheme(@PathVariable Long id, @Valid @RequestBody Theme theme){
        return new ResponseEntity<>(themeService.updateTheme(id,theme), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable Long id){
        themeService.deleteTheme(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}

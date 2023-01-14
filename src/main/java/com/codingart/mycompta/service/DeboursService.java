package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Debours;

import java.util.List;

public interface DeboursService {
    Debours addDebours(Debours debours);
    Debours getDebours(Long id);
    List<Debours> getAllDebours();
    Debours updateDebours(Long id, Debours debours);
    void deleteDebours(Long id);
}

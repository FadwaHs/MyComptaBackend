package com.codingart.mycompta.service;

import com.codingart.mycompta.model.MotCle;

import java.util.List;

public interface MotCleService {
    MotCle addMotCle(MotCle motCle);
    MotCle getMotCle(Long id);
    List<MotCle> getAllMotCle();
    MotCle updateMotCle(Long id, MotCle motCle);
    void deleteMotCle(Long id);
}

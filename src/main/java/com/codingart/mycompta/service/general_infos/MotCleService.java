package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.model.general_infos.MotCle;

import java.util.List;

public interface MotCleService {
    MotCle addMotCle(MotCle motCle);
    MotCle getMotCle(Long id);
    List<MotCle> getAllMotCle();
    MotCle updateMotCle(Long id, MotCle motCle);
    void deleteMotCle(Long id);
}

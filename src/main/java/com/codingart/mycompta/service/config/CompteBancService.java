package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.CompteBanc;

import java.util.List;

public interface CompteBancService {
    CompteBanc addCompteBanc(CompteBanc compteBanc);
    CompteBanc getCompteBanc(Long id);
    List<CompteBanc> getAllCompteBanc();
    CompteBanc updateCompteBanc(Long id, CompteBanc compteBanc);
    void deleteCompteBanc(Long id);
}

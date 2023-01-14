package com.codingart.mycompta.service;

import com.codingart.mycompta.model.CompteBanc;

import java.util.List;

public interface CompteBancService {
    CompteBanc addCompteBanc(CompteBanc compteBanc);
    CompteBanc getCompteBanc(Long id);
    List<CompteBanc> getAllCompteBanc();
    CompteBanc updateCompteBanc(Long id, CompteBanc compteBanc);
    void deleteCompteBanc(Long id);
}

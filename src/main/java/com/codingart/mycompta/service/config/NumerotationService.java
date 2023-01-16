package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.Numerotation;

import java.util.List;

public interface NumerotationService {
    Numerotation addNumerotation(Numerotation numerotation);
    Numerotation getNumerotation(Long id);
    List<Numerotation> getAllNumerotation();
    Numerotation updateNumerotation(Long id, Numerotation numerotation);
    void deleteNumerotation(Long id);
}

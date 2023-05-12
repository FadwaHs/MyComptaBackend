package com.codingart.mycompta.service.comptabilite;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.comptabilite.CompteCharge;
import com.codingart.mycompta.repository.comptabilite.CompteChargesRepository;
import com.codingart.mycompta.repository.comptabilite.CompteTiersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompteChargeServiceImpl implements CompteChargeService {


    private final CompteChargesRepository compteChargesRepository;
    private final String message = "compteCharge not found for this id :: ";
    @Override
    public CompteCharge addCompteCharge(CompteCharge compteCharge) {
        return compteChargesRepository.save(compteCharge);
    }

    @Override
    public CompteCharge getCompteCharge(Long id) {
        return compteChargesRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<CompteCharge> getAllCompteCharge() {
        return compteChargesRepository.findAll();
    }

    @Override
    public CompteCharge updateCompteCharge(Long id, CompteCharge compteCharge) {
        compteChargesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(message+id));
        compteCharge.setId(id);
        return compteChargesRepository.save(compteCharge);    }

    @Override
    public void deleteCompteCharge(Long id) {
        compteChargesRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        compteChargesRepository.deleteById(id);

    }
}

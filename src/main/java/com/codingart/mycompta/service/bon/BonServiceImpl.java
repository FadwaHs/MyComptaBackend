package com.codingart.mycompta.service.bon;

import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.repository.bon.BonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BonServiceImpl implements BonService{
    private final BonRepository bonRepository;
    @Override
    public List<Bons> getAllBons() {
        return bonRepository.findAll();
    }
}

package com.codingart.mycompta.service.devis;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.model.devis.Interet;
import com.codingart.mycompta.repository.devis.ConditionReglementRepository;
import com.codingart.mycompta.service.devis.ConditionReglementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionReglementServiceImpl implements ConditionReglementService {

    private final ConditionReglementRepository conditionReglementRepository;
    private final String message = "ConditionReglement not found for this id :: ";


    @Override
    public void initConditionsReglement() {
        List<ConditionReglement> conditionReglementList = new ArrayList<>();
        String[] defaultconditionsReglement= {"Voir détail ci après", "À réception", "Fin de mois"
                ,"10 jours", "30 jours", "30 jours fin de mois", "45 jours", "45 jours fin de mois",
                "60 jours", "60 jours fin de mois", "90 jours", "90 jours fin de mois" ,"120 jours"};

        for (int i=0 ; i < defaultconditionsReglement.length; i++) {
            conditionReglementList.add(ConditionReglement.builder().id((long) (i+1)).name(defaultconditionsReglement[i]).build() );
        }
        conditionReglementRepository.saveAll(conditionReglementList);
    }

    @Override
    public ConditionReglement addConditionReglement(ConditionReglement conditionReglement) {
        return conditionReglementRepository.save(conditionReglement);

    }

    @Override
    public ConditionReglement getConditionReglement(Long id) {
        return conditionReglementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<ConditionReglement> getAllConditionReglement() {
        return conditionReglementRepository.findAll();
    }

    @Override
    public ConditionReglement updateConditionReglement( Long id, ConditionReglement conditionReglement) {
        conditionReglementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        conditionReglement.setId(id);
        return conditionReglementRepository.save(conditionReglement);
    }

    @Override
    public void deleteConditionReglement(Long id) {
        conditionReglementRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        conditionReglementRepository.deleteById(id);
    }

}

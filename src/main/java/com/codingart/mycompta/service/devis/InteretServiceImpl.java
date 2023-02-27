package com.codingart.mycompta.service.devis;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.devis.Interet;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.repository.devis.InteretRepository;
import com.codingart.mycompta.service.devis.InteretService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InteretServiceImpl implements InteretService {

    private final InteretRepository interetRepository;
    private final String message = "Interet not found for this id :: ";


    @Override
    public void initInterets() {
        List<Interet> interetList = new ArrayList<>();
        String[] defaultInterets = {"Pas d'intérêts de retard", "1% par mois", "1,5% par mois"
                ,"2% par mois", "Taux d’intérêt légal en vigueur","À préciser"};
        for (int i=0 ; i < defaultInterets.length; i++) {
            interetList.add(Interet.builder().id((long) (i+1)).name(defaultInterets[i]).build() );
        }
        interetRepository.saveAll(interetList);
    }

    @Override
    public Interet addInteret(Interet interet) {
        return interetRepository.save(interet);
    }

    @Override
    public Interet getInteret(Long id) {
        return interetRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Interet> getAllInteret() {
        return interetRepository.findAll();
    }

    @Override
    public Interet updateInteret( Long id, Interet interet) {
        interetRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        interet.setId(id);
        return interetRepository.save(interet);
    }

    @Override
    public void deleteInteret(Long id) {
        interetRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        interetRepository.deleteById(id);
    }

}

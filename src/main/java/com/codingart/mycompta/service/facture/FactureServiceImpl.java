package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.repository.facture.FactureRepository;
import com.codingart.mycompta.util.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService{

    private final FactureRepository factureRepository;
    private final String message = "FactureSimple not found for this id :: ";
    private final FormatService formatService;
    @Override
    public Facture addFacture(Facture facture) {
        return null;
    }

    @Override
    public Facture getFacture(Long id) {
        return null;
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture updateFacture(Long id, Facture facture) {
        return null;
    }

    @Override
    public Map<String, Object> getListFactures(String data, int page, int size) {
        List<Facture> facturesList ;
        Pageable paging = PageRequest.of(page, size);

        Page<Facture> pageTuts = null;
        if (data == null) {
            pageTuts = factureRepository.findAll(paging);
        }
        else {

            var simple = factureRepository.findBySimpleDataContaining(data, paging);
            var avoire = factureRepository.findByAvoireDataContaining(data, paging);
            List<Facture> combinedList = Stream.concat(simple.getContent().stream(), avoire.getContent().stream())
                    .collect(Collectors.toList());
            pageTuts = new PageImpl<>(combinedList, paging, combinedList.size());
        }

        facturesList = pageTuts.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("factures", facturesList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public void deleteFacture(Long id) {

    }
}

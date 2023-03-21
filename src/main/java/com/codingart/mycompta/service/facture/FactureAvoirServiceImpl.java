package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.enums.FactureAvoirStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.repository.facture.FactureAvoirRepository;
import com.codingart.mycompta.service.facture.FactureAvoirService;
import com.codingart.mycompta.util.FormatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FactureAvoirServiceImpl implements FactureAvoirService {

    private final FactureAvoirRepository factureAvoirRepository;
    private final String message = "FactureAvoir not found for this id :: ";
    private final FormatService formatService;

    @Override
    public FactureAvoir addFactureAvoir(FactureAvoir factureAvoir) {
        factureAvoir.setDate(new Date());
        Map<String,Object> mapData = formatService.createFormat(new Date(),"A");
        factureAvoir.setCode((String) mapData.get("format"));
        factureAvoir.setCmp((Long) mapData.get("cmp"));
        return factureAvoirRepository.save(factureAvoir);

    }

    @Override
    public FactureAvoir getFactureAvoir(Long id) {
        return factureAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<FactureAvoir> getAllFactureAvoir() {
        return factureAvoirRepository.findAll();
    }

    @Override
    public Map<String, Object> getListFactureAvoir(String data, FactureAvoirStatus status, int page, int size) {
        List<FactureAvoir> factureAvoirList ;
        Pageable paging = PageRequest.of(page, size);

        Page<FactureAvoir> pageTuts;
        if (data == null && status == null) {
            pageTuts = factureAvoirRepository.findAll(paging);
        }
        else if(data != null && status !=null){
            pageTuts = factureAvoirRepository.findByDataContainingWithStatus(data, status, paging);
        } else if (data != null) {
            pageTuts = factureAvoirRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = factureAvoirRepository.findFactureAvoirByStatus(status, paging);
        }

        factureAvoirList = pageTuts.getContent();
//        List<DevisDto> devisDtoList = devis.stream().map(p -> modelMapper.map(p,DevisDto.class)).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("factureAvoirs", factureAvoirList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public FactureAvoir updateFactureAvoir( Long id, FactureAvoir factureAvoir) {
        factureAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAvoir.setId(id);
        return factureAvoirRepository.save(factureAvoir);
    }

    @Override
    public void deleteFactureAvoir(Long id) {
        factureAvoirRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAvoirRepository.deleteById(id);
    }

}

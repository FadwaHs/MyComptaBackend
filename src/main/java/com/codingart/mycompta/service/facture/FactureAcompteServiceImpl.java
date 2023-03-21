package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.repository.facture.FactureAcompteRepository;
import com.codingart.mycompta.service.facture.FactureAcompteService;
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
public class FactureAcompteServiceImpl implements FactureAcompteService {

    private final FactureAcompteRepository factureAcompteRepository;
    private final String message = "FactureAcompte not found for this id :: ";

    private final FormatService formatService;


    @Override
    public FactureAcompte addFactureAcompte(FactureAcompte factureAcompte) {
        factureAcompte.setDate(new Date());
        Map<String,Object> mapData = formatService.createFormat(new Date(),"FA");
        factureAcompte.setCode((String) mapData.get("format"));
        factureAcompte.setCmp((Long) mapData.get("cmp"));
        return factureAcompteRepository.save(factureAcompte);

    }

    @Override
    public FactureAcompte getFactureAcompte(Long id) {
        return factureAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<FactureAcompte> getAllFactureAcompte() {
        return factureAcompteRepository.findAll();
    }

    @Override
    public Map<String, Object> getListFactureAcompte(String data, FactureAcompteStatus status, int page, int size) {
        List<FactureAcompte> factureAcompteList ;
        Pageable paging = PageRequest.of(page, size);

        Page<FactureAcompte> pageTuts;
        if (data == null && status == null) {
            pageTuts = factureAcompteRepository.findAll(paging);
        }
        else if(data != null && status !=null){
            pageTuts = factureAcompteRepository.findByDataContainingWithStatus(data, status, paging);
        } else if (data != null) {
            pageTuts = factureAcompteRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = factureAcompteRepository.findFactureAcompteByStatus(status, paging);
        }

        factureAcompteList = pageTuts.getContent();
//        List<DevisDto> devisDtoList = devis.stream().map(p -> modelMapper.map(p,DevisDto.class)).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("factureAcomptes", factureAcompteList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public FactureAcompte updateFactureAcompte( Long id, FactureAcompte factureAcompte) {
        factureAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAcompte.setId(id);
        return factureAcompteRepository.save(factureAcompte);
    }

    @Override
    public void deleteFactureAcompte(Long id) {
        factureAcompteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureAcompteRepository.deleteById(id);
    }

}

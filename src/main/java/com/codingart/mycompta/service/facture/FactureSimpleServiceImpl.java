package com.codingart.mycompta.service.facture;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.repository.facture.FactureSimpleRepository;
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
public class FactureSimpleServiceImpl implements FactureSimpleService {

    private final FactureSimpleRepository factureSimpleRepository;
    private final String message = "FactureSimple not found for this id :: ";
    private final FormatService formatService;



    @Override
    public FactureSimple addFactureSimple(FactureSimple factureSimple) {
        factureSimple.setDate(new Date());
        Map<String,Object> mapData = formatService.createFormat(new Date(),"F");
        factureSimple.setCode((String) mapData.get("format"));
        factureSimple.setCmp((Long) mapData.get("cmp"));
        return factureSimpleRepository.save(factureSimple);

    }

    @Override
    public FactureSimple getFactureSimple(Long id) {
        return factureSimpleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<FactureSimple> getAllFactureSimple() {
        return factureSimpleRepository.findAll();
    }

    @Override
    public Map<String, Object> getListFactureSimple(String data, FactureSimpleStatus status, int page, int size) {
        List<FactureSimple> factureSimpleList ;
        Pageable paging = PageRequest.of(page, size);

        Page<FactureSimple> pageTuts;
        if (data == null && status == null) {
            pageTuts = factureSimpleRepository.findAll(paging);
        }
        else if(data != null && status !=null){
            pageTuts = factureSimpleRepository.findByDataContainingWithStatus(data, status, paging);
        } else if (data != null) {
            pageTuts = factureSimpleRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = factureSimpleRepository.findFactureSimpleByStatus(status, paging);
        }

        factureSimpleList = pageTuts.getContent();
//        List<DevisDto> devisDtoList = devis.stream().map(p -> modelMapper.map(p,DevisDto.class)).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("factureSimples", factureSimpleList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public FactureSimple updateFactureSimple( Long id, FactureSimple factureSimple) {
        factureSimpleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureSimple.setId(id);
        return factureSimpleRepository.save(factureSimple);
    }

    @Override
    public void deleteFactureSimple(Long id) {
        factureSimpleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        factureSimpleRepository.deleteById(id);
    }

}

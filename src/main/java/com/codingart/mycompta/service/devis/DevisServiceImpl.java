package com.codingart.mycompta.service.devis;

import com.codingart.mycompta.dto.DevisDto;
import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.enums.DevisStatus;
import com.codingart.mycompta.repository.devis.DevisRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DevisServiceImpl implements DevisService {

    private final DevisRepository devisRepository;
    private final ModelMapper modelMapper;
    private final String message = "Devis not found for this id :: ";
    private static Devis currentDevis;

    @Override
    public Devis addDevis(Devis devis) {
        return devisRepository.save(devis);

    }

    @Override
    public DevisDto getDevis(Long id) {
        currentDevis = devisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        return modelMapper.map(currentDevis, DevisDto.class);
    }

    @Override
    public List<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    @Override
    public Map<String, Object> getListDevis(String data,DevisStatus status, int page, int size) {
        List<Devis> devis ;
        Pageable paging = PageRequest.of(page, size);

        Page<Devis> pageTuts;
        if (data == null && status == null) {
            pageTuts = devisRepository.findAll(paging);
        }
        else if(data != null && status !=null){
            pageTuts = devisRepository.findByDataContainingWithStatus(data, status, paging);
        } else if (data != null) {
            pageTuts = devisRepository.findByDataContaining(data, paging);
        } else {
            pageTuts = devisRepository.findDevisByStatus(status, paging);
        }

        devis = pageTuts.getContent();
        List<DevisDto> devisDtoList = devis.stream().map(p -> modelMapper.map(p,DevisDto.class)).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("devis", devisDtoList);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public Devis updateDevis( Long id, Devis devis) {
        devisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        devis.setId(id);
        return devisRepository.save(devis);
    }

    @Override
    public void deleteDevis(Long id) {
        devisRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        devisRepository.deleteById(id);
    }

}

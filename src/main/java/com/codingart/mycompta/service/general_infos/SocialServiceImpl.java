package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.general_infos.Social;
import com.codingart.mycompta.repository.general_infos.SocialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SocialServiceImpl implements SocialService{


    private final SocialRepository socialRepository;
    private final String message = "Social not found for this id :: ";

    @Override
    public Social addSocial(Social social) {
        return socialRepository.save(social);

    }

    @Override
    public Social getSocial(Long id) {
        return socialRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Social> getAllSocial() {
        return socialRepository.findAll();
    }

    @Override
    public Social updateSocial( Long id, Social social) {
        socialRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        social.setId(id);
        return socialRepository.save(social);
    }

    @Override
    public void deleteSocial(Long id) {
        socialRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        socialRepository.deleteById(id);
    }

}

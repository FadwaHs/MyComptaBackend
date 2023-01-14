package com.codingart.mycompta.service.impl;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.Profile;
import com.codingart.mycompta.repository.ProfileRepository;
import com.codingart.mycompta.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final String message = "Profile not found for this id :: ";


    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);

    }

    @Override
    public Profile getProfile(Long id) {
        return profileRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public Profile updateProfile( Long id, Profile profile) {
        profileRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        profile.setId(id);
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        profileRepository.deleteById(id);
    }

}

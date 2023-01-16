package com.codingart.mycompta.service.config;

import com.codingart.mycompta.model.config.Profile;

import java.util.List;

public interface ProfileService {
    Profile addProfile(Profile profile);
    Profile getProfile(Long id);
    List<Profile> getAllProfile();
    Profile updateProfile(Long id, Profile profile);
    void deleteProfile(Long id);
}

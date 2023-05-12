package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.model.general_infos.Social;

import java.util.List;

public interface SocialService {

    Social addSocial(Social social);
    Social getSocial(Long id);
    List<Social> getAllSocial();
    Social updateSocial(Long id, Social social);
    void deleteSocial(Long id);
}

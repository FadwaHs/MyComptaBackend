package com.codingart.mycompta.dto;

import com.codingart.mycompta.enums.ClientType;
import com.codingart.mycompta.model.client.Secteur;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.comptabilite.CompteTiers;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.model.general_infos.Social;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Societe} entity
 */
@Data
public class SocieteDto implements Serializable {
    private Long id;
    private String slug;
    @NotBlank(message = "Name may not be blank")
    private String name;
    private String ntva;
    private String siren;
    private String codeNaf;
    private String website;
    @NotBlank(message = "Language may not be blank")
    private String Language;
    private Address address;
    //++
    private List<Phone> phoneList;
    private List<MotCle> motCleList;
//   private List<Devis> devisList;

    private boolean prospect;
    private ClientType societeType = ClientType.Aucun;
    private List<Social> socialList;
    private Secteur secteur;
    private String note;
}
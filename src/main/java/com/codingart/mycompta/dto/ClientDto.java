package com.codingart.mycompta.dto;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.codingart.mycompta.model.client.Client} entity
 */
@Getter
@Setter
public class ClientDto implements Serializable {
    private Long id;
    private String slug;
    @NotBlank(message = "firstName may not be blank")
    private String firstName;
    @NotBlank(message = "lastName may not be blank")
    private String lastName;
    @Email(message = "Invalid Email")
    private String email;
    private String function;
    private String website;
    @NotBlank(message = "language may not be blank")
    private String language;
    private String note;
    private List<Phone> phoneList;
    private Address address;
    private List<MotCle> motCleList;

//    private List<Devis> devisList;
    private SocieteDto societe;
}
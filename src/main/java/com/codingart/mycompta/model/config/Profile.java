package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.model.auth.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

//@JsonIdentityInfo(scope = Profile.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String emailPro;
    @NotBlank(message = "FirstName may not be blank")
    private String firstName;
    @NotBlank(message = "LastName may not be blank")
    private String lastName;
    private String NameSociete;
    private String siren;
    private String codeNaf;
    private String nTva;
    private String website;


//     relation between User and profile
    @OneToOne
User user ;

//    Indirect relation between User with Environment
    @OneToMany(mappedBy = "profile",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Phone> phoneList;

//    Relation between Profile and Address
    @OneToOne
Address address;

}

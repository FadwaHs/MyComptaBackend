package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
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

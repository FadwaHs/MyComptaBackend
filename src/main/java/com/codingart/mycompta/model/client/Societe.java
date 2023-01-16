package com.codingart.mycompta.model.client;

import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank(message = "Name may not be blank")
    private String name;
    private String nTva;
    private String siren;
    private String codeNaf;
    private String website;
    @NotBlank(message = "Language may not be blank")
    private String Language;


//    Relation Between Societe and Address
    @OneToOne
    private Address address;

//    Relation between Societe and phone
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phoneList;

    //    Relation between Societe and MotCle
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

//    Relation Between Societe and Client
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Client> clientList;

    //    Relation Between Societe and Devis
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

//    Relation between Societe and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;

}

package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.config.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String address;
    @ElementCollection()
    @CollectionTable(name = "complementAddresses",joinColumns = @JoinColumn(name = "address_id"))
    private List<String> complementAddress;
    private String codePostal;
    private String city;
    private String country;


//    Relation Between Address and Profile
    @JsonBackReference("profile_address")
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

//    Relation Between Address and Client
    @JsonBackReference("client_address")
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    Relation Between Address and Societe
    @JsonBackReference("societe_address")
    @OneToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

}

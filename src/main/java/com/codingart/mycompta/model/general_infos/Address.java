package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.livraison.Livraison;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@JsonIdentityInfo(scope = Address.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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


    // Relation Between Address and Client
    @JsonBackReference("client_address")
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Relation Between Address and Societe
    @JsonBackReference("societe_address")
    @OneToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;


    //    Relation Between Address and Client
    @JsonBackReference("fournisseur_address")
    @OneToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;


    @JsonBackReference("livraison_address")
    @OneToOne
    @JoinColumn(name = "livraison_id")
    private Livraison livraison;


}

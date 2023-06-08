package com.codingart.mycompta.model.client;

import com.codingart.mycompta.enums.ClientType;
import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.model.general_infos.Social;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

////@JsonIdentityInfo(scope = Societe.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Societe {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String slug;
    @NonNull
    @NotBlank(message = "Name may not be blank")
    private String name;
    private String ntva;
    private String siren;
    private String codeNaf;
    private String website;
    @NotBlank(message = "Language may not be blank")
    private String Language;
    private String note;

    //+
    private boolean prospect;
    @Enumerated(EnumType.STRING)
    private ClientType societeType = ClientType.Aucun;

    @JsonManagedReference("societe_social")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Social> socialList;


    @ManyToOne
    @JoinColumn(name = "secteur_id")
    private Secteur secteur;

    //+


    //    Relation Between Societe and Address
    @JsonManagedReference("societe_address")
    @OneToOne(mappedBy = "societe",cascade = CascadeType.REMOVE)
    private Address address;

    //    Relation between Societe and phone
    @JsonManagedReference("societe_phone")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phoneList;

    //    Relation between Societe and MotCle
    @JsonManagedReference("societe_motCle")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation Between Societe and Client
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonManagedReference("societe_client")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Client> clientList;

    //    Relation Between Societe and Devis
    @JsonBackReference("societe_Devis")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

    //    Relation Between Societe and FactureSimple
    @JsonBackReference("societe_factureSimple")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FactureSimple> factureSimpleList;

    //    Relation Between Societe and FactureAvoir
    @JsonBackReference("societe_factureAvoir")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FactureAvoir> factureAvoirList;

    //    Relation between Societe and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;


    //    Relation between Societe and OPP
    @JsonBackReference("societe_opp")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Opportunite> opportuniteList;


    //+

    //    Relation Between Societe and fournisseur
    @JsonBackReference("societe_fournisseur")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Fournisseur> fournisseurList;

    //+

    //++
    public void initializeCollections() {

        if(this.opportuniteList == null) {
            this.opportuniteList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<Opportunite> uniqueOpportunites = new HashSet<>(this.opportuniteList);
            this.opportuniteList.clear();
            this.opportuniteList.addAll(uniqueOpportunites);
        }

        if (this.devisList == null) {
            this.devisList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<Devis> uniqueDevis = new HashSet<>(this.devisList);
            this.devisList.clear();
            this.devisList.addAll(uniqueDevis);
        }
        //++
        // Factures Simples:
        if (this.factureSimpleList == null) {
            this.factureSimpleList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<FactureSimple> uniqueSimple = new HashSet<>(this.factureSimpleList);
            this.factureSimpleList.clear();
            this.factureSimpleList.addAll(uniqueSimple);
        }

        // Factures Avoirs:
        if (this.factureAvoirList == null) {
            this.factureAvoirList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<FactureAvoir> uniqueAvoir = new HashSet<>(this.factureAvoirList);
            this.factureAvoirList.clear();
            this.factureAvoirList.addAll(uniqueAvoir);
        }

    }



    @PrePersist
    public void setSlugPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}
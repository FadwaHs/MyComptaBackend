package com.codingart.mycompta.model.fournisseur;


import com.codingart.mycompta.dto.SocieteDto;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.comptabilite.CompteCharge;
import com.codingart.mycompta.model.comptabilite.CompteTiers;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.model.general_infos.Social;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Fournisseur {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String slug;
    @NonNull
    @NotBlank(message = "firstName may not be blank")
    private String firstName;
    @NonNull
    @NotBlank(message = "lastName may not be blank")
    private String lastName;
    @Email(message = "Invalid Email")
    private String email;
    private String function;
    private String website;
    private String note;
    private String reference;

    //    Relation between Fournisseur and MotCle
    @JsonManagedReference("fournisseur_motCle")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between fournisseur and Phone
    @JsonManagedReference("fournisseur_phone")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phoneList ;

    //    Relation Between fournisseur and Address
    @JsonManagedReference("fournisseur_address")
    @OneToOne(mappedBy = "fournisseur",cascade = CascadeType.REMOVE)
    private Address address;

    @JsonManagedReference("fournisseur_social")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Social> socialList;

    @ManyToOne
    @JoinColumn(name = "compteCharge_id")
    private CompteCharge compteCharge;

    @ManyToOne
    @JoinColumn(name = "compte_tiers_id")
    private CompteTiers compte_tiers;

    //    Relation between fournisseur and Societe

    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;


    @JsonBackReference("fournisseur_avoirfournisseur")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AvoireFournisseur> avoireFournisseurList= new ArrayList<>();

    @JsonBackReference("fournisseur_simplefournisseur")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<SimpleFournisseur> simpleFournisseurList= new ArrayList<>();



    //  Relation between fournisseur and Bons type

    @JsonBackReference("fournisseur_bonslv")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BonLivraison> bonLivraisonList = new ArrayList<>();

    @JsonBackReference("fournisseur_bonscmd")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BonsCommande> bonsCommandes = new ArrayList<>();


    @PostLoad
    public void initializeCollections() {

        if (this.bonLivraisonList == null) {
            this.bonLivraisonList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<BonLivraison> uniqueBLs = new HashSet<>(this.bonLivraisonList);
            this.bonLivraisonList.clear();
            this.bonLivraisonList.addAll(uniqueBLs);
        }

        if (this.bonsCommandes == null) {
            this.bonsCommandes = new ArrayList<>();
        } else {
            // remove duplicates
            Set<BonsCommande> uniqueBn = new HashSet<>(this.bonsCommandes);
            this.bonsCommandes.clear();
            this.bonsCommandes.addAll(uniqueBn);
        }

        //++
        // Factures Simples:
        if (this.simpleFournisseurList == null) {
            this.simpleFournisseurList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<SimpleFournisseur> uniqueSimple = new HashSet<>(this.simpleFournisseurList);
            this.simpleFournisseurList.clear();
            this.simpleFournisseurList.addAll(uniqueSimple);
        }

        // Factures Avoirs:
        if (this.avoireFournisseurList == null) {
            this.avoireFournisseurList = new ArrayList<>();
        } else {
            // remove duplicates
            Set<AvoireFournisseur> uniqueAvoir = new HashSet<>(this.avoireFournisseurList);
            this.avoireFournisseurList.clear();
            this.avoireFournisseurList.addAll(uniqueAvoir);
        }

    }

    @PrePersist
    public void setSlugPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}








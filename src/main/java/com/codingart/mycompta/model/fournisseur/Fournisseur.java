package com.codingart.mycompta.model.fournisseur;


import com.codingart.mycompta.dto.SocieteDto;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.comptabilite.CompteCharge;
import com.codingart.mycompta.model.comptabilite.CompteTiers;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import com.codingart.mycompta.model.general_infos.Social;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
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


    //  Relation between fournisseur and FactureFournisseur
    @JsonManagedReference("fournisseur_facturefournisseur")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FactureFournisseur> factureFournisseurList = new ArrayList<>();



    // To load List For Different Type Of Facture Fournisseur
    public List<AvoireFournisseur> getAvoirFournisseurList() {
        return factureFournisseurList.stream()
                .filter(facture -> facture instanceof AvoireFournisseur)
                .map(facture -> (AvoireFournisseur) facture)
                .collect(Collectors.toList());
    }

    public List<SimpleFournisseur> getSimpleFournisseurList() {
        return factureFournisseurList.stream()
                .filter(facture -> facture instanceof SimpleFournisseur)
                .map(facture -> (SimpleFournisseur) facture)
                .collect(Collectors.toList());
    }


    //  Relation between fournisseur and Bons
    @JsonManagedReference("fournisseur_bons")
    @OneToMany(mappedBy = "fournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Bons> bonsList = new ArrayList<>();


    // To load List For Different Type Of Bons Fournisseur
    public List<BonsCommande> getBonsCommandeFournisseurList() {
        return bonsList.stream()
                .filter(bons -> bons instanceof BonsCommande)
                .map(bons -> (BonsCommande) bons)
                .collect(Collectors.toList());
    }

    public List<BonLivraison> getBonLivraisonFournisseurList() {
        return bonsList.stream()
                .filter(bons -> bons instanceof BonLivraison)
                .map(bons -> (BonLivraison) bons)
                .collect(Collectors.toList());
    }

    @PrePersist
    public void setSlugPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}








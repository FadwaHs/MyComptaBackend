package com.codingart.mycompta.model.devis;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.Paiement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
////@JsonIdentityInfo(scope = ModeReglement.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeReglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Mode may not be blank")
    private String name;

//    Relation between ModeReglement and Devis
    @JsonBackReference("devis_modeReglement")
    @OneToMany(mappedBy = "modeReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

    //    Relation between ModeReglement and Devis
    @JsonBackReference("facture_modeReglement")
    @OneToMany(mappedBy = "modeReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Facture> factureList;

    //+

    //    Relation between ModeReglement and facturefounisseur
    @JsonBackReference("facturefournisseur_modeReglement")
    @OneToMany(mappedBy = "modeReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FactureFournisseur> factureFournisseurList;


    //    Relation between ModeReglement and BonsCommande
    @JsonBackReference("bonscommande_modeReglement")
    @OneToMany(mappedBy = "modeReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<BonsCommande> bonsCommandeList;


    //+

    //++
//    Relation between ModeReglement and Paiement
    @JsonBackReference("paiement_modeReglement")
    @OneToMany(mappedBy = "modeReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Paiement> paiementList;
}

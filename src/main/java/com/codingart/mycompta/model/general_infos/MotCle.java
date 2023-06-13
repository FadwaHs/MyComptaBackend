package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.FactureFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(scope = MotCle.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotCle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Mot may not be blank")
    private String mot;

    //    Relation between MotCle and Societe
    @JsonBackReference("societe_motCle")
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between MotCle and Client
    @JsonBackReference("client_motCle")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //    Relation between MotCle and Fournisseur
    @JsonBackReference("fournisseur_motCle")
    @ManyToOne
    @JoinColumn(name = "fournissuer_id")
    private Fournisseur fournisseur;

    //    Relation between MotCle and Devis
    @JsonBackReference("devis_motCle")
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

    //    Relation between MotCle and facture
    @JsonBackReference("facture_motCle")
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;


    //    Relation between MotCle and opportunite
    @JsonBackReference("opp_motCle")
    @ManyToOne
    @JoinColumn(name = "opportunite_id")
    private Opportunite opportunite;


    //+

    //    Relation between MotCle and facturefounisseur two type

    @JsonBackReference("avoireFournisseur_motCle")
    @ManyToOne
    @JoinColumn(name = "avoireFournisseur_id")
    private AvoireFournisseur avoireFournisseur;

    @JsonBackReference("simpleFournisseur_motCle")
    @ManyToOne
    @JoinColumn(name = "simpleFournisseur_id")
    private SimpleFournisseur simpleFournisseur;


    //    Relation between MotCle and bons two type

    @JsonBackReference("bonslv_motCle")
    @ManyToOne
    @JoinColumn(name = "bons_livraison_id")
    private BonLivraison bonLivraison;

    @JsonBackReference("bonscmd_motCle")
    @ManyToOne
    @JoinColumn(name = "bons_commande_id")
    private BonsCommande bonsCommande;



    //+


}

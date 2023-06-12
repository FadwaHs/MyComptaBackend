package com.codingart.mycompta.model.article;

import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.Bons;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@JsonIdentityInfo(scope = Article.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Quantity may not be Null")
    private int quantity;
    @NotNull(message = "PrixHT may not be null")
    private double prixHT;
    private double reduction;
    private boolean redIsPercentage;
    private double tva;
    private String description;
    private String reference;

//    Relation between Article and Devis
    @JsonBackReference("devis_article")
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

//    Relation between Article and FactureSimple
    @JsonBackReference("factureSimple_article")
    @ManyToOne
    @JoinColumn(name = "factureSimple_id")
    private FactureSimple factureSimple;

//    Relation between Article and FactureAvoir
    @JsonBackReference("factureAvoir_article")
    @ManyToOne
    @JoinColumn(name = "factureAvoir_id")
    private FactureAvoir factureAvoir;

//    Relation between Article and TypeArticle
    @ManyToOne
    @JoinColumn(name = "type_article_id")
    private TypeArticle typeArticle;


    //+

    //    Relation between Article and FactureAvoirFournisseur
    @JsonBackReference("avoirefournisseur_article")
    @ManyToOne
    @JoinColumn(name = "avoireFournisseur_id")
    private AvoireFournisseur avoireFournisseur;

    //    Relation between Article and SimpleFournisseur
    @JsonBackReference("simplefournisseur_article")
    @ManyToOne
    @JoinColumn(name = "simpleFournisseur_id")
    private SimpleFournisseur simpleFournisseur;

    //    Relation between Article and BonLivraison
    @JsonBackReference("bonLivraison_article")
    @ManyToOne
    @JoinColumn(name = "bon_livraison_id")
    private BonLivraison bonLivraison;

    //    Relation between Article and BonCommandes
    @JsonBackReference("bonsCommande_article")
    @ManyToOne
    @JoinColumn(name = "bon_commande_id")
    private BonsCommande bonsCommande;


    //+

}

package com.codingart.mycompta.model.bon;
import com.codingart.mycompta.enums.BCStatus;
import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.enums.LivraisonStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.livraison.Livraison;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BonsCommande extends  Bons{

    private double remise;
    private boolean remIsPercentage;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BCStatus bcStatus = BCStatus.Draft;

    @Enumerated(EnumType.STRING)
    @NotNull
    private LivraisonStatus livraisonStatusBc = LivraisonStatus.Pending;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date date_Livraison;

    //    Relation between BonsCommande and ConditionReglement
    @ManyToOne
    @JoinColumn(name = "condition_reglement_id")
    private ConditionReglement conditionReglement;

    //    Relation between BonsCommande and ModeReglement
    @ManyToOne
    @JoinColumn(name = "mode_reglement_id")
    private ModeReglement modeReglement;

    // Référence à la classe Livraison

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livraison_id")
    private Livraison livraison;


    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    //    Relation between Bons and Article
    @JsonManagedReference("bonsCommande_article")
    @OneToMany(mappedBy = "bonsCommande",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //    Relation between Bons Commande and MotCle
    @OneToMany(mappedBy = "bonsCommande",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;


}


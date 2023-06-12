package com.codingart.mycompta.model.facturefournisseur;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.enums.LivraisonStatus;
import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue("SimpleFournisseur") 
public class SimpleFournisseur extends  FactureFournisseur{

    @Enumerated(EnumType.STRING)
    @NotNull
    private SimpleFournisseurStatus status = SimpleFournisseurStatus.Brouillon;
    @Enumerated(EnumType.STRING)
    @NotNull
    private LivraisonStatus livraisonStatus = LivraisonStatus.Pending;

    private double remise;
    private boolean remIsPercentage;

    //    Relation between SimpleFournisseur and Article
    @JsonManagedReference("simplefournisseur_article")
    @OneToMany(mappedBy = "simpleFournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //    Relation between SimpleFournisseur and MotCle
    @OneToMany(mappedBy = "simpleFournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between FactureFournisseur and Fournisseur
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;


}

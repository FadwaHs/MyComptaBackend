package com.codingart.mycompta.model.facturefournisseur;


import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.FactureAvoirStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import com.codingart.mycompta.model.general_infos.MotCle;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue("AvoirFournisseur")
public class AvoireFournisseur  extends  FactureFournisseur{

    @Enumerated(EnumType.STRING)
    @NotNull
    private AvoireFournisseurStatus status = AvoireFournisseurStatus.DRAFT;

    private double remise;
    private boolean remIsPercentage;

    //    Relation between avoirefournisseur and MotCle
    @OneToMany(mappedBy = "avoireFournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between avoirefournisseur and Article

    @JsonManagedReference("avoirefournisseur_article")
    @OneToMany(mappedBy = "avoireFournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //++
    @JsonManagedReference("avoirFournisseur_paiement")
    @OneToMany(mappedBy = "avoirFournisseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement>  paiementList ;


    //    Relation between FactureFournisseur and Fournisseur

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

}

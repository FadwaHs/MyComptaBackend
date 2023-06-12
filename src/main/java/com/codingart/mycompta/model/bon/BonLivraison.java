package com.codingart.mycompta.model.bon;


import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
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
public class BonLivraison extends  Bons
{
    @Enumerated(EnumType.STRING)
    @NotNull
    private BLStatus blStatus = BLStatus.Draft;

    private double remise;
    private boolean remIsPercentage;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    //    Relation between Bons and Article
    @JsonManagedReference("bonLivraison_article")
    @OneToMany(mappedBy = "bonLivraison",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

}

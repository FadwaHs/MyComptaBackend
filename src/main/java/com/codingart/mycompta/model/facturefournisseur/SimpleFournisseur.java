package com.codingart.mycompta.model.facturefournisseur;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.enums.LivraisonStatus;
import com.codingart.mycompta.enums.SimpleFournisseurStatus;
import com.codingart.mycompta.model.article.Article;
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
    private SimpleFournisseurStatus status = SimpleFournisseurStatus.Draft;
    @Enumerated(EnumType.STRING)
    @NotNull
    private LivraisonStatus livraisonStatus = LivraisonStatus.Pending;

    //    Relation between SimpleFournisseur and Article
    @JsonManagedReference("simplefournisseur_article")
    @OneToMany(mappedBy = "simpleFournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;


}

package com.codingart.mycompta.model.facturefournisseur;


import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.FactureAvoirStatus;
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
//@DiscriminatorValue("AvoirFournisseur")
public class AvoireFournisseur  extends  FactureFournisseur{

    @Enumerated(EnumType.STRING)
    @NotNull
    private AvoireFournisseurStatus status = AvoireFournisseurStatus.Brouillon;

    //    Relation between avoirefournisseur and Article

    @JsonManagedReference("avoirefournisseur_article")
    @OneToMany(mappedBy = "avoireFournisseur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

}

package com.codingart.mycompta.model.bon;


import com.codingart.mycompta.enums.AvoireFournisseurStatus;
import com.codingart.mycompta.enums.BLStatus;
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
public class BonLivraison extends  Bons
{
    @Enumerated(EnumType.STRING)
    @NotNull
    private BLStatus blStatus = BLStatus.Draft;

}

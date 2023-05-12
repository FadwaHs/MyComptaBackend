package com.codingart.mycompta.model.bon;
import com.codingart.mycompta.enums.BCStatus;
import com.codingart.mycompta.enums.BLStatus;
import com.codingart.mycompta.enums.LivraisonStatus;
import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.model.livraison.Livraison;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BonsCommande extends  Bons{

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

}

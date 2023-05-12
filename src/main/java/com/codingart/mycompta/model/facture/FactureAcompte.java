package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.config.CompteBanc;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

//@JsonIdentityInfo(scope = FactureAcompte.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureAcompte extends Facture{

    private double montantPayed;
    private boolean monIsPercentage;
    @Enumerated(EnumType.STRING)
    @NotNull
    private FactureAcompteStatus status = FactureAcompteStatus.PROVISIONAL;

    //    Relation between FactureAcompte and CompteBanc
    @OneToOne(mappedBy = "factureAcompte",cascade = CascadeType.REMOVE)
    private CompteBanc compteBanc;

    //    Relation between FactureAcompte and Devis
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

}

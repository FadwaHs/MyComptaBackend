package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.enums.FactureAcompteStatus;
import com.codingart.mycompta.enums.FactureAvoirStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

//@JsonIdentityInfo(scope = FactureAvoir.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureAvoir extends Facture{

    private double remise;
    private boolean remIsPercentage;
    @Enumerated(EnumType.STRING)
    @NotNull
    private FactureAvoirStatus status = FactureAvoirStatus.PROVISIONAL;

    //    Relation between FactureAvoir and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between FactureAvoir and Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //    Relation between FacturAvoir and Article
    @JsonManagedReference("factureAvoir_article")
    @OneToMany(mappedBy = "factureAvoir",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //    Relation between FactureAvoir and Debours
    @OneToMany(mappedBy = "factureAvoir",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Debours> debours;
}

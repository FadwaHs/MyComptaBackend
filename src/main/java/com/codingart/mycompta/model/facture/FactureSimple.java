package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.enums.FactureSimpleStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

//@JsonIdentityInfo(scope = FactureSimple.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureSimple extends Facture{

    private double remise;
    private boolean remIsPercentage;
    @Enumerated(EnumType.STRING)
    @NotNull
    private FactureSimpleStatus status = FactureSimpleStatus.PROVISIONAL;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_paiement;

    //    Relation between FactureSimple and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between FactureSimple and Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //    Relation between FacturSimple and Article
    @JsonManagedReference("factureSimple_article")
    @OneToMany(mappedBy = "factureSimple",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //    Relation between FacturSimple and MotCle
    @OneToMany(mappedBy = "factureSimple",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;


    //    Relation between FactureSimple and Debours
    @OneToMany(mappedBy = "factureSimple",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Debours> debours;


}

package com.codingart.mycompta.model.devis;

import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.util.FormatService;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;


//@JsonIdentityInfo(scope = Devis.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String slug;
    private String code;
    private Long cmp;
    private int validationDuration;
    private String devise;
    private double remise;
    private boolean remIsPercentage;
    private String textIntro;
    private String textCond;
    private String piedPage;
    private String condVente;
    private double totalHT;
    private double totalTTC;
    @Enumerated(EnumType.STRING)
    @NotNull
    private DevisStatus status = DevisStatus.PROVISIONAL;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    //    Relation between Devis and MotCle
    @JsonManagedReference("devis_motCle")
    @OneToMany(mappedBy = "devis",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between Devis and Article
    @JsonManagedReference("devis_article")
    @OneToMany(mappedBy = "devis",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //    Relation between Devis and Facture
    @JsonBackReference("devis_factureAcompte")
    @OneToMany(mappedBy = "devis",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FactureAcompte> factureAcompteList;

    //    Relation between Devis and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between Devis and Client
    //    @JsonManagedReference("client_devis")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //    Relation between Devis and ConditionReglement
    @ManyToOne
    @JoinColumn(name = "condition_reglement_id")
    private  ConditionReglement conditionReglement;

    //    Relation between Devis and ModeReglement
    @ManyToOne
    @JoinColumn(name = "mode_reglement_id")
    private ModeReglement modeReglement;

    //    Relation between Devis and Interet
    @ManyToOne
    @JoinColumn(name = "interet_id")
    private Interet interet;

    @PrePersist
    public void setDataPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }
}

package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeD;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date validationDuration;
    private String devise;
    private double remise;
    private char typeRemise;
    private String textIntro;
    private String textCond;
    private String piedPage;
    private String condVente;
    @ColumnDefault("false")
    private boolean isDestined;
    @ColumnDefault("false")
    private boolean isFinalized;
    @ColumnDefault("false")
    private boolean isSigned;
    @ColumnDefault("false")
    private boolean isRefused;

//    @ElementCollection
//    private List<Character> Status;


    //    Relation between Devis and MotCle
    @OneToMany(mappedBy = "devis",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between Devis and Article
    @OneToMany(mappedBy = "devis",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    //    Relation between Devis and Facture
    @OneToMany(mappedBy = "devis",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Facture> factureList;

    //    Relation between Devis and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between Devis and Client
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

    

}

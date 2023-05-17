package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.devis.Interet;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.model.facturefournisseur.Paiement;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

//@JsonIdentityInfo(scope = Facture.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_facture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_facture")
    private Long id;
    @Column(unique = true)
    private String slug;
    private String code;
    private Long cmp;
    private String devise;
    private String textIntro;
    private String textCond;
    private String piedPage;
    private String condVente;
    private double totalHT;
    private double totalTTC;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_finalisation;

    //    Relation between Facture and ConditionReglement
    @ManyToOne
    @JoinColumn(name = "condition_reglement_id")
    private ConditionReglement conditionReglement;

    //    Relation between Facture and ModeReglement
    @ManyToOne
    @JoinColumn(name = "mode_reglement_id")
    private ModeReglement modeReglement;

    //    Relation between Facture and Interet
    @ManyToOne
    @JoinColumn(name = "interet_id")
    private Interet interet;

//    Relation between Facture and MotCle
    @OneToMany(mappedBy = "facture",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //++
    //Relation between Facture and Paiement

    //@JsonManagedReference("facture_paiement")
   // @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Paiement>  paiementList ;
    //++


//    Self join Relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facture_id")
    private Facture parent;

    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Facture> children;


    //    Relation between Facture and Opportunite
    @ManyToOne
    @JoinColumn(name = "opportunite_id")
    private Opportunite opportunite;

    @PrePersist
    public void setDataPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}

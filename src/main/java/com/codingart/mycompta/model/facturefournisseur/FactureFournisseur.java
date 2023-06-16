package com.codingart.mycompta.model.facturefournisseur;


import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.devis.ConditionReglement;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_facturefournisseur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  abstract class  FactureFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_facture")
    private Long id;
    @Column(unique = true)
    private String slug;
    private String numero_interne;
    private String numero_externe;
    private String devise;
    private double totalHT;
    private double totalTTC;
    private String note;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;


    //    Relation between FactureFournisseur and ConditionReglement
    @ManyToOne
    @JoinColumn(name = "condition_reglement_id")
    private ConditionReglement conditionReglement;

    //    Relation between FactureFournisseur and ModeReglement
    @ManyToOne
    @JoinColumn(name = "mode_reglement_id")
    private ModeReglement modeReglement;




    @PrePersist
    public void setDataPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }
}

package com.codingart.mycompta.model.bon;


import com.codingart.mycompta.model.article.Article;
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
@DiscriminatorColumn(name = "type_bon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Bons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Temporal(TemporalType.DATE)
    private Date date_creation;


    //    Relation between Bons and MotCle
    @OneToMany(mappedBy = "bons",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    @PrePersist
    public void setDataPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}

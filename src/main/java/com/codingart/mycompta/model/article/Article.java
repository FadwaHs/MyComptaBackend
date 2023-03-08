package com.codingart.mycompta.model.article;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@JsonIdentityInfo(scope = Article.class,generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Quantity may not be Null")
    private int quantity;
    @NotNull(message = "PrixHT may not be null")
    private double prixHT;
    private double reduction;
    private boolean redIsPercentage;
    private double tva;
    private String description;

//    private double TotalHT;
//    private double totalTTC;

//    Relation between Article and Devis
    @JsonBackReference("devis_article")
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

//    Relation between Article and Facture
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

//    Relation between Article and TypeArticle
    @ManyToOne
    @JoinColumn(name = "type_article_id")
    private TypeArticle typeArticle;

}

package com.codingart.mycompta.model.article;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

//    Relation between Article and Facture
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

//    Relation between Article and TypeArticle
    @JsonBackReference("article_type")
    @ManyToOne
    @JoinColumn(name = "type_article_id")
    private TypeArticle typeArticle;

}

package com.codingart.mycompta.model.article;

import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
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
    private char reductionType;
    private double tva;
    private double TotalHT;
    private double totalTTC;
    private String description;


//    Relation between Article and Devis
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

package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.model.article.Article;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@JsonIdentityInfo(scope = Debours.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Debours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ReferenceFacture;
    @NotBlank(message = "MontantHT may not be blank")
    private double montantHT;
    private String description;


//    Relation between Debours and Facture
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
}

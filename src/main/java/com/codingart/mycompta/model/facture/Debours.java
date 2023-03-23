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


//    Relation between Debours and FactureSimple
    @ManyToOne
    @JoinColumn(name = "factureSimple_id")
    private FactureSimple factureSimple;

    //    Relation between Debours and FactureAvoir
    @ManyToOne
    @JoinColumn(name = "factureAvoir_id")
    private FactureAvoir factureAvoir;
}

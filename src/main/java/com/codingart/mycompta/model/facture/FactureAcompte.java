package com.codingart.mycompta.model.facture;

import com.codingart.mycompta.model.article.Article;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

//@JsonIdentityInfo(scope = FactureAcompte.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureAcompte extends Facture{
    private double montantPayed;
    private char typeMontant;



}

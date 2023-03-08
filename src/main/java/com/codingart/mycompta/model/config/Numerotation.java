package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.facture.FactureSimple;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

//@JsonIdentityInfo(scope = Numerotation.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Numerotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String format;
    private int minCounterSize;
    private String resertCounter;
    private int startCounterDevis;
    private int startCounterFacture;
    private int startCounterAvoir;
    private int startCounterAcompte;

    @OneToOne
    @JoinColumn(name = "config_facture_id")
    ConfigFacture configFacture ;

}

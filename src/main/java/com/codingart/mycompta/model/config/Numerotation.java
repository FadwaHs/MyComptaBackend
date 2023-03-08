package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

//@JsonIdentityInfo(scope = Numerotation.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Builder
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

    @JsonBackReference("environment_numerotation")
    @OneToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;


}

package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

//@JsonIdentityInfo(scope = Defaults.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Defaults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String devise;
    private String typeArt;
    private double tva;
    private boolean tvaNotApplicable;
    private String textTvaNotApplicable_fr;
    private String textTvaNotApplicable_en;
    private String condReg;
    private String modeReg;
    private String interet;

    //     Relation between Default and Environment
    @OneToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;

}

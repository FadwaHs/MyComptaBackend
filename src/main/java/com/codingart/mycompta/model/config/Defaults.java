package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.environment.Environment;
import jakarta.persistence.*;
import lombok.*;

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

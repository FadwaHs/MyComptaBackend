package com.codingart.mycompta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
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

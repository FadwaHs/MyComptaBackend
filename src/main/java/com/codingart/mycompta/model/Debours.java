package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
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

package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotCle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Mot may not be blank")
    private Long mot;

    //    Relation between MotCle and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between MotCle and Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //    Relation between MotCle and Devis
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

//    Relation between MotCle and Devis
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;
}

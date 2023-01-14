package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteBanc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "IBAN may not be blank")
    private String iban;
    @NotBlank(message = "BIC may not be blank")
    private String bic;
    @NotBlank(message = "Titulaire IBAN may not be blank")
    private String titulaire;
    @NotBlank(message = "LibelleCompte may not be blank")
    private String libelleCompte;


    //    Relation between CompteBanc and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;

}

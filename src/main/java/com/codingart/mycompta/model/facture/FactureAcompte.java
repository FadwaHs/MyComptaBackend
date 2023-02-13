package com.codingart.mycompta.model.facture;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureAcompte extends Facture{
    private double montantPayed;
    private char typeMontant;



}

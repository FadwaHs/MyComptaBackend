package com.codingart.mycompta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureAvoir extends Facture{

    private double remise;
    private char TypeRemise;
    private boolean isDestined;
}

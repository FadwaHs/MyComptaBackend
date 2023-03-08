package com.codingart.mycompta.model.facture;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

//@JsonIdentityInfo(scope = FactureSimple.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureSimple extends Facture{
    private double remise;
    private char TypeRemise;
    private boolean isDestined;

}

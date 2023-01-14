package com.codingart.mycompta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigAcompte extends ConfigPreference {

    private double montant;
    private char typeMontant;
}

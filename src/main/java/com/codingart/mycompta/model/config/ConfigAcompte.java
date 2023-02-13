package com.codingart.mycompta.model.config;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigAcompte extends ConfigPreference {

    private double montant;
    private char typeMontant;
}

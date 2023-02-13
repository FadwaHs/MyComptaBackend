package com.codingart.mycompta.model.config;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigFacture extends ConfigPreference{

    @OneToOne
    private Numerotation numerotation;

}

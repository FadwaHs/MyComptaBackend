package com.codingart.mycompta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigFacture extends ConfigPreference{

    @OneToOne
    private Numerotation numerotation;

}

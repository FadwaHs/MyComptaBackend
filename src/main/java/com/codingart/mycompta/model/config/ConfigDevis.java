package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.facture.FactureSimple;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

//@JsonIdentityInfo(scope = ConfigDevis.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ConfigDevis extends ConfigPreference{

    private boolean hideBlocSignature;
}

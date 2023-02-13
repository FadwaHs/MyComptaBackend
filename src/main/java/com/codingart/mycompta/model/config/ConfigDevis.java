package com.codingart.mycompta.model.config;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ConfigDevis extends ConfigPreference{

    private boolean hideBlocSignature;
}

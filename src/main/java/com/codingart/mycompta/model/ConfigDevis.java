package com.codingart.mycompta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ConfigDevis extends ConfigPreference{

    private boolean hideBlocSignature;
}

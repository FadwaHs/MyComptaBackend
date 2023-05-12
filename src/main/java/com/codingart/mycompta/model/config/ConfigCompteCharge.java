package com.codingart.mycompta.model.config;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class ConfigCompteCharge {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private  int code;
    private  String libelle;
}

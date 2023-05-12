package com.codingart.mycompta.model.config;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder

public class ConfigCompteTiers {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private  int code;
    private  String name;

}

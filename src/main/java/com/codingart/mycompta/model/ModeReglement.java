package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeReglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Mode may not be blank")
    private String mode;

//    Relation between ModeReglement and Devis
    @OneToMany(mappedBy = "modeReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;
}

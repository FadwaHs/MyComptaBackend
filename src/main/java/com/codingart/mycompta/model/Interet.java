package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Interet may not be blank")
    private String interet;


//    Relation between Interet and Devis
    @OneToMany(mappedBy = "interet",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;
}

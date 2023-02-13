package com.codingart.mycompta.model.devis;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConditionReglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "ConditionName may not be blank")
    private String conditionName;


//    Relation between ConditionReglement and Devis
    @OneToMany(mappedBy = "conditionReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;
}

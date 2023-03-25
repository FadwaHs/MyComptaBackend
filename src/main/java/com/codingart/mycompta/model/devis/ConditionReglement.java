package com.codingart.mycompta.model.devis;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.facture.Facture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
////@JsonIdentityInfo(scope = ConditionReglement.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
    private String name;


//    Relation between ConditionReglement and Devis
    @JsonBackReference("devis_conditionReglement")
    @OneToMany(mappedBy = "conditionReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

    //    Relation between ConditionReglement and facture
    @JsonBackReference("facture_conditionReglement")
    @OneToMany(mappedBy = "conditionReglement",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Facture> factureList;
}

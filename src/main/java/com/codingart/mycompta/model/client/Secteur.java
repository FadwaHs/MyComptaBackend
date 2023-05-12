package com.codingart.mycompta.model.client;

import com.codingart.mycompta.model.general_infos.Social;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Secteur {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String name;

    @JsonBackReference("secteur_societe")
    @OneToMany(mappedBy = "secteur",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Societe> societeList;


}

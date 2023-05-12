package com.codingart.mycompta.model.opportunite;


import com.codingart.mycompta.model.client.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Etape {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String etapename;
    private int probabilite;

    @ManyToOne
    @JoinColumn(name = "pipeline_id")
    //@JsonBackReference
    private Pipeline pipeline;

    @JsonBackReference("etape_opp")
    @OneToMany(mappedBy = "etape",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Opportunite> opportuniteList;


}

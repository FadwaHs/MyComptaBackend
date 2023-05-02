package com.codingart.mycompta.model.opportunite;


import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.OppStatus;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Entity
//lombock
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Opportunite {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String slug;
    @Column(unique = true)
    private String code;
    private String Intitule;
    private double MantantHT;
    private String devise;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    private double Probabilite;
    private String Note;

    @Enumerated(EnumType.STRING)
    @NotNull
    private OppStatus oppStatus = OppStatus.INPROGRESS;

    //    Relation between Opp and MotCle
    //@JsonManagedReference("opp_motCle")
    @OneToMany(mappedBy = "opportunite",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between OPP and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between OPP and Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

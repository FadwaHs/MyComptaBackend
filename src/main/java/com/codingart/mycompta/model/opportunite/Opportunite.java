package com.codingart.mycompta.model.opportunite;


import com.codingart.mycompta.enums.DevisStatus;
import com.codingart.mycompta.enums.OppStatus;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.facture.FactureAcompte;
import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.validation.annotation.Validated;

import javax.annotation.processing.Generated;
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
    private String intitule;
    private double mantantHT;
    private String devise;
    private String source;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    private double probabilite;
    private String note;
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

    // Relation between OPP and Client
    // @JsonBackReference("client_opp")
    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //++Relation ManytoOne
    @ManyToOne
    @JoinColumn(name = "etape_id")
    private Etape etape;

    //+Relation OnetoMany

    @JsonBackReference("opp_devis")
    @OneToMany(mappedBy = "opportunite",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devis;

    @JsonBackReference("opp_facture")
    @OneToMany(mappedBy = "opportunite",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Facture> factureList;

    @PrePersist
    public void setDataPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}

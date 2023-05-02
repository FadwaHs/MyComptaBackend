package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.facture.Facture;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

//@JsonIdentityInfo(scope = MotCle.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotCle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Mot may not be blank")
    private String mot;

    //    Relation between MotCle and Societe
    @JsonBackReference("societe_motCle")
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    //    Relation between MotCle and Client
    @JsonBackReference("client_motCle")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //    Relation between MotCle and Devis
    @JsonBackReference("devis_motCle")
    @ManyToOne
    @JoinColumn(name = "devis_id")
    private Devis devis;

    //    Relation between MotCle and Devis
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;


    //    Relation between MotCle and opportunite
    @ManyToOne
    @JoinColumn(name = "opportunite_id")
    private Opportunite opportunite;
}

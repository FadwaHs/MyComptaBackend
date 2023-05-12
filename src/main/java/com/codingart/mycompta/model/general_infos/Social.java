package com.codingart.mycompta.model.general_infos;


import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Social {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private  String name;
    private String link;

    @JsonBackReference("client_social")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonBackReference("societe_social")
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    @JsonBackReference("fournisseur_social")
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;



}

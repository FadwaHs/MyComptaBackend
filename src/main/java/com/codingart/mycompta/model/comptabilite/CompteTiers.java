package com.codingart.mycompta.model.comptabilite;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
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
public class CompteTiers {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private  int code;
    private  String libelle;

    @JsonBackReference("client_compte_tiers")
    @OneToMany(mappedBy = "compte_tiers",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Client> clientList;

    @JsonBackReference("fournisseur_compte_tiers")
    @OneToMany(mappedBy = "compte_tiers",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Fournisseur> fournisseurList;




}

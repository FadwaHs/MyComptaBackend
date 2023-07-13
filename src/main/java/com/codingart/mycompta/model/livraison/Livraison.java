package com.codingart.mycompta.model.livraison;

import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.general_infos.Address;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Informations liées à la livraison

    private int nombreColis;
    private double poidsTotal;
    private double volume;
    private String numeroSuivi;
    private String urlSuivi;

    // Relation Between Adresse et  livraison
    //@ManyToOne
   // @JoinColumn(name = "address_id")
    //private Address adresseLivraison;
    @JsonManagedReference("livraison_address")
    @OneToOne(mappedBy = "livraison",cascade = CascadeType.REMOVE)
    private Address adresseLivraison;


    // Relation One-to-One with BonsCommande

    @JsonBackReference("livraison_bonscommande")
    @OneToOne(mappedBy = "livraison")
    private BonsCommande bonsCommande;
}

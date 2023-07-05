package com.codingart.mycompta.model.facturefournisseur;


import com.codingart.mycompta.model.config.CompteBanc;
import com.codingart.mycompta.model.devis.ModeReglement;
import com.codingart.mycompta.model.facture.Facture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // Type de règlement : Débit ou Crédit
    private double montant; // Montant du règlement
    private String reference; // Référence
    private String note; // Note
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateReglement; // Date du règlement
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateRemise; // Date du Remise


    //++

    @JsonBackReference("simpleFournisseur_paiement")
    @ManyToOne
    @JoinColumn(name = "simple_fournisseur_id")
    private SimpleFournisseur simpleFournisseur;

    @JsonBackReference("avoirFournisseur_paiement")
    @ManyToOne
    @JoinColumn(name = "avoir_fournisseur_id")
    private AvoireFournisseur avoirFournisseur;
    //++
    //@JsonBackReference("facture_paiement")
    //@ManyToOne
    //@JoinColumn(name = "facture_id")
    // private Facture facture;

    // ++

    @ManyToOne
    @JoinColumn(name = "compteDebit_bancaire_id")
    private CompteBanc compteDebiteur;

    @ManyToOne
    @JoinColumn(name = "compteCredit_bancaire_id")
    private CompteBanc compteCrediteur;

    //++
//    Relation between Paiementw and ModeReglement
    @ManyToOne
    @JoinColumn(name = "mode_reglement_id")
    private ModeReglement modeReglement;

}

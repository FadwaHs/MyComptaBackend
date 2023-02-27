package com.codingart.mycompta.model.client;

import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Societe {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String slug;
    @NonNull
    @NotBlank(message = "Name may not be blank")
    private String name;
    private String ntva;
    private String siren;
    private String codeNaf;
    private String website;
    @NotBlank(message = "Language may not be blank")
    private String Language;


//    Relation Between Societe and Address
    @JsonManagedReference("societe_address")
    @OneToOne(mappedBy = "societe",cascade = CascadeType.REMOVE)
    private Address address;

//    Relation between Societe and phone
    @JsonManagedReference("societe_phone")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phoneList;

    //    Relation between Societe and MotCle
    @JsonManagedReference("societe_motCle")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

//    Relation Between Societe and Client
    @JsonManagedReference("societe_client")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Client> clientList;

    //    Relation Between Societe and Devis
    @JsonManagedReference("societe_devis")
    @OneToMany(mappedBy = "societe",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

//    Relation between Societe and Environment
    @JsonBackReference("environment_societe")
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;


    @PrePersist
    public void setSlugPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }

}

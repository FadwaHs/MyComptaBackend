package com.codingart.mycompta.model.client;


import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Phone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Client {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String slug;
    @NonNull
    @NotBlank(message = "firstName may not be blank")
    private String firstName;
    @NonNull
    @NotBlank(message = "lastName may not be blank")
    private String lastName;

    @Email(message = "Invalid Email")
    private String email;
    private String function;
    private String website;
    @NotBlank(message = "language may not be blank")
    private String language;

    private String note;


//    Relation between Client and Phone
    @JsonManagedReference("client_phone")
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phoneList ;

//    Relation Between Client and Address
    @JsonManagedReference("client_address")
    @OneToOne(mappedBy = "client",cascade = CascadeType.REMOVE)
    private Address address;


//    Relation between Client and MotCle
    @JsonManagedReference("client_motCle")
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between Client and Devis
    @JsonManagedReference("client_devis")
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

//    Relation between Client and Societe
    @JsonBackReference("societe_client")
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

//    Relation between Client and Environment
    @JsonBackReference("environment_client")
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;

    @PrePersist
    public void setSlugPrePersist(){
        this.slug = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
    }


}
package com.codingart.mycompta.model.client;


import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.devis.Devis;
import com.codingart.mycompta.model.general_infos.Address;
import com.codingart.mycompta.model.general_infos.MotCle;
import com.codingart.mycompta.model.general_infos.Note;
import com.codingart.mycompta.model.general_infos.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Email(message = "Invalid Email")
    private String email;
    @NotBlank(message = "firstName may not be blank")
    private String firstName;
    @NotBlank(message = "lastName may not be blank")
    private String lastName;
    private String website;
    @NotBlank(message = "language may not be blank")
    private String language;


//    Relation between Client and Phone
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Phone> phoneList ;

//    Relation Between Client and Address
    @OneToOne
    private Address address;

//    Relation between Client and Note
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Note> noteList;

//    Relation between Client and MotCle
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<MotCle> motCleList;

    //    Relation between Client and Devis
    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Devis> devisList;

//    Relation between Client and Societe
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

//    Relation between Client and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;

}
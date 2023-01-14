package com.codingart.mycompta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank(message = "phoneNumber may not be blank")
    private String phoneNumber;


//     relation between Phone and Profile
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

//    Relation between Phone and Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    Relation between Societe and Phone
    @ManyToOne/*(cascade = CascadeType.PERSIST)*/
    @JoinColumn(name = "societe_id")
    private Societe societe;
}

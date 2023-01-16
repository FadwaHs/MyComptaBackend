package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.config.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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

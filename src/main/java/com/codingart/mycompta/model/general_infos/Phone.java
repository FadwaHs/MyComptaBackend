package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.config.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@JsonIdentityInfo(scope = Phone.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
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
    @JsonBackReference("client_phone")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    Relation between Societe and Phone
    @JsonBackReference("societe_phone")
    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;


}

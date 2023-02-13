package com.codingart.mycompta.model.auth;

import com.codingart.mycompta.model.environment.Environment;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    Relation between Membre and User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    Relation between Membre and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;


}

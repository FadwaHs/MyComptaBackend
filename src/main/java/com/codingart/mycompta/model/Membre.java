package com.codingart.mycompta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Entity
@Data
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

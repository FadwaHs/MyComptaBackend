package com.codingart.mycompta.model.auth;

import com.codingart.mycompta.model.article.Article;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


//@JsonIdentityInfo(scope = Role.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "RoleName may not be blank")
    private String roleName;

//    Indirect relation between Role and Membre
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_membre",
            joinColumns = {
                    @JoinColumn(name = "role_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "membre_id")
            }
    )
    private List<Membre> memberList;

}

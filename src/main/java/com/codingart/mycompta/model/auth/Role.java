package com.codingart.mycompta.model.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Entity
@Data
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

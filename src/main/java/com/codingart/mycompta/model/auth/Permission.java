package com.codingart.mycompta.model.auth;

import com.codingart.mycompta.model.article.Article;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

//@JsonIdentityInfo(scope = Permission.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "PermissionName may not be blank")
    private String permissionName;

//    Indirect relation between Permission and Membre
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permission_membre",
            joinColumns = {
                    @JoinColumn(name = "permission_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "membre_id")
            }
    )
    private List<Membre> memberList;
}

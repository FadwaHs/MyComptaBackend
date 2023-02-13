package com.codingart.mycompta.model.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

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

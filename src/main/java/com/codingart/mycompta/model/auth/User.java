package com.codingart.mycompta.model.auth;

import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.model.environment.Environment;
import com.codingart.mycompta.model.config.Profile;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

//@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Email may not be blank")
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password may not be blank")
    private String password;
    @ColumnDefault("false")
    private boolean isNotified;
    @ColumnDefault("false")
    private boolean isActivated;
    @ColumnDefault("false")
    private boolean isValidated;


//     relation between User and profile
    @OneToOne
    @JoinColumn(name = "profile_id")
Profile profile ;

//    Indirect relation between User with Environment
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Environment> environmentList;


//    relation between User and membre
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Membre> membreList;


}

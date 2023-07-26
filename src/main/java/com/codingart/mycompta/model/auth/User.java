package com.codingart.mycompta.model.auth;

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
@Data
@Builder
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
    @NotBlank(message = "username may not be blank")
    private String username;
    @ColumnDefault("false")
    private boolean isNotified;
    @ColumnDefault("false")
    private boolean isActivated;
    @ColumnDefault("false")
    private boolean isValidated;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roleList;
}

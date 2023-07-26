package com.codingart.mycompta.model.environment;

import com.codingart.mycompta.model.auth.Membre;
import com.codingart.mycompta.model.auth.User;
import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.model.config.*;
import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.general_infos.Address;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

//@JsonIdentityInfo(scope = Environment.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name may not be blank")
    private String name;
    private String Description;


    //     Relation between Environment and Theme
    @OneToOne
    private Theme theme;

    //     Relation between Environment and Default
    @OneToOne
    private Defaults defaults;


//     Relation between Environment and CompteBanc
    @OneToMany(mappedBy = "environment",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CompteBanc> compteBancList;


//     Relation between Environment and configPreference
    @OneToMany(mappedBy = "environment",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ConfigPreference> configPreferenceList;

//     Relation between Environment and CompteBanc
    @OneToMany(mappedBy = "environment",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ConfigTypeArticle> configTypeArticleList;

//    Relation between Environment and Numerotation
    @JsonManagedReference("environment_numerotation")
    @OneToOne(mappedBy = "environment",cascade = CascadeType.REMOVE)
    private Numerotation numerotation;

//    Self join Relation
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Environment> children;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "environment_id")
    private Environment parent;

}

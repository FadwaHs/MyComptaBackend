package com.codingart.mycompta.model.article;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

////@JsonIdentityInfo(scope = TypeArticle.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "TypeName may not be blank")
    private String name_fr;

    @NotBlank(message = "TypeName may not be blank")
    private String name_en;


    //    Relation between TypeArticle and Article
    @JsonBackReference
    @OneToMany(mappedBy = "typeArticle",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;
}

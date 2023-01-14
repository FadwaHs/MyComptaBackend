package com.codingart.mycompta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigTypeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_fr;
    private String name_en;


//    Relation between ConfigTypeArticle and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;
}

package com.codingart.mycompta.model.config;

import com.codingart.mycompta.model.environment.Environment;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logo;
    private String police;
    private String Color;

//    Relation Between Theme and Environment
    @OneToOne
    @JoinColumn(name = "environmet_id")
    private Environment environment;
}

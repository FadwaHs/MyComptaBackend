package com.codingart.mycompta.model.config;
import com.codingart.mycompta.model.environment.Environment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ConfigPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_config_preference")
    private Long id;
    @ColumnDefault("true")
    private boolean showName;
    private String textIntro_fr;
    private String textCond_fr;
    private String piedPage_fr;
    private String condVente_fr;
    private String textIntro_en;
    private String textCond_en;
    private String piedPage_en;
    private String condVente_en;



//    Relation between ConfigPreference and Environment
    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;

}

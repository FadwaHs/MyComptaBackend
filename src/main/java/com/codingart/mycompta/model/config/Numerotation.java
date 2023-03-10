package com.codingart.mycompta.model.config;

import com.codingart.mycompta.enums.ResetCounter;
import com.codingart.mycompta.model.environment.Environment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//@JsonIdentityInfo(scope = Numerotation.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Numerotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "format may not be blank")
    private String format;
    @Min( value = 1, message = "minCounterSize should not be less than 1")
    @Max( value = 14, message = "minCounterSize should not be greater than 14")
    private int minCounterSize;
//    @NotNull(message = "resertCounter may not be null")
    @Enumerated(EnumType.STRING)
    private ResetCounter resetCounter;
    @Min( value = 1, message = "startCounterDevis should not be less than 1")
    @Max( value = 32000, message = "startCounterDevis should not be greater than 32000")
    private int startCounterDevis;
    @Min( value = 1, message = "startCounterFacture should not be less than 1")
    @Max( value = 32000, message = "startCounterFacture should not be greater than 32000")
    private int startCounterFacture;
    @Min( value = 1, message = "startCounterAvoir should not be less than 1")
    @Max( value = 32000, message = "startCounterAvoir should not be greater than 32000")
    private int startCounterAvoir;
    @Min( value = 1, message = "startCounterAcompte should not be less than 1")
    @Max( value = 32000, message = "startCounterAcompte should not be greater than 32000")
    private int startCounterAcompte;

    @JsonBackReference("environment_numerotation")
    @OneToOne
    @JoinColumn(name = "environment_id")
    private Environment environment;


}

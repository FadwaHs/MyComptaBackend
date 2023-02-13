package com.codingart.mycompta.dto;

import com.codingart.mycompta.model.environment.Environment;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Environment} entity
 */
@Getter
@Setter
public class ChildEnvironmentDto implements Serializable {
    private  Long id;
    @NotBlank(message = "Name may not be blank")
    private  String name;
    private  String Description;
}
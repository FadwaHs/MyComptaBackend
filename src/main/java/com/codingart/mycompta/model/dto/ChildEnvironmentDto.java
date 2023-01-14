package com.codingart.mycompta.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.codingart.mycompta.model.Environment} entity
 */
@Data
public class ChildEnvironmentDto implements Serializable {
    private  Long id;
    @NotBlank(message = "Name may not be blank")
    private  String name;
    private  String Description;
}
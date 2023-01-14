package com.codingart.mycompta.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.codingart.mycompta.model.Phone} entity
 */
@Data
public class PhoneDto implements Serializable {
    private Long id;
    @NotBlank(message = "phoneNumber may not be blank")
    private String phoneNumber;
}
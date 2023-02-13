package com.codingart.mycompta.dto;

import com.codingart.mycompta.model.general_infos.Phone;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Phone} entity
 */
@Getter
@Setter
public class PhoneDto implements Serializable {
    private Long id;
    @NotBlank(message = "phoneNumber may not be blank")
    private String phoneNumber;
}
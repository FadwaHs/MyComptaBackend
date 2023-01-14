package com.codingart.mycompta.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.codingart.mycompta.model.Client} entity
 */
@Data
public class ClientDto implements Serializable {
    private  Long id;
    @Email(message = "Invalid Email")
    private  String email;
    @NotBlank(message = "firstName may not be blank")
    private  String firstName;
    @NotBlank(message = "lastName may not be blank")
    private  String lastName;
    private  String website;
    @NotBlank(message = "language may not be blank")
    private  String language;
    private  List<PhoneDto> phoneList;
}
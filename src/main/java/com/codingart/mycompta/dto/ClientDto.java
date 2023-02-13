package com.codingart.mycompta.dto;

import com.codingart.mycompta.model.client.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Client} entity
 */
@Getter
@Setter
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
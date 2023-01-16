package com.codingart.mycompta.model.general_infos;

import com.codingart.mycompta.model.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank(message = "NoteName may not be blank")
    private String noteName;

//    Relation between Note and Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

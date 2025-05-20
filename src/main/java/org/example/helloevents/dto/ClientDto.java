package org.example.helloevents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto implements Serializable {
    Long idClient;
    String nom;
    String email;
    String password;
}
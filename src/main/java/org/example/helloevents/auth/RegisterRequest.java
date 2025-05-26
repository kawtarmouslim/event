package org.example.helloevents.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom;
    private String email;

    public RegisterRequest(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    private String password;
}

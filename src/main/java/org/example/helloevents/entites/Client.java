package org.example.helloevents.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helloevents.dto.EvenementDto;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nom;
    private  String email;
    private String password;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Resrvation> resrvations;
}

package org.example.helloevents.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resrvation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResrvation;
    private String nomResrvation;
    private String description;
    private String dateReservation;
    private String place;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "idClient")
    Client client;
    @ManyToOne
    @JoinColumn(name = "idEvenement")
    Evenement event;
}

package org.example.helloevents.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEvenement;
    private  String titre;
    private String type;
    private int nombrePlase;
    private String description;
    private  String dateDebut;
    private  String dateFin;
    @OneToMany(mappedBy = "event" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Resrvation> resrvations;



}

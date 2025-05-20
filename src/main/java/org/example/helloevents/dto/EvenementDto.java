package org.example.helloevents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.example.helloevents.entites.Evenement;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EvenementDto implements Serializable {
    Long idEvenement;
    String titre;
    String type;
    int nombrePlase;
    String description;
    String dateDebut;
    String dateFin;
}
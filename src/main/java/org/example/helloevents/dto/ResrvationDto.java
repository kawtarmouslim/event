package org.example.helloevents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResrvationDto implements Serializable {
    Long idResrvation;
    String nomResrvation;
    String description;
    String dateReservation;
    String place;
    double prix;
    Long idClient;
    Long idEvenement;

}
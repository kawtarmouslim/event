package org.example.helloevents.controller;

import lombok.AllArgsConstructor;
import org.example.helloevents.dto.ResrvationDto;
import org.example.helloevents.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ResrvationController {
    private ReservationService reservationService;
    @PostMapping("reserver")
    private ResponseEntity reserve(@RequestBody ResrvationDto resrvationDto) {
        ResrvationDto resrvationDto1=reservationService.resrvation(resrvationDto);
        return ResponseEntity.ok().body(resrvationDto1);

    }
}

package org.example.helloevents.controller;

import lombok.AllArgsConstructor;
import org.example.helloevents.dto.EvenementDto;
import org.example.helloevents.services.EvenementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EvenementController {
    private   EvenementService service;


    @PostMapping("event")

    public ResponseEntity<EvenementDto> saveEvenement(@RequestBody EvenementDto e) {
        EvenementDto saved = service.save(e);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("events")
    private ResponseEntity<List<EvenementDto>> findAllEvenements() {
        List<EvenementDto> saved=service.findAll();
        return ResponseEntity.ok(saved);
    }
    @GetMapping("event/{id}")
    public ResponseEntity<EvenementDto> findEvenementById(@PathVariable Long id) {
        EvenementDto evenementDto=service.finById(id);
        return ResponseEntity.ok(evenementDto);
    }
    @PutMapping("event/{id}")
    public ResponseEntity<EvenementDto> updateEvenement( @PathVariable Long id,@RequestBody EvenementDto evenementDto) {
        EvenementDto update= service.update(id,evenementDto);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<EvenementDto> deleteEvenement(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("type/{type}")
    private ResponseEntity<List<EvenementDto>> findAllEvenementsByType(@PathVariable String type) {
        List<EvenementDto> saved=service.findEvenementByType(type);
        return ResponseEntity.ok(saved);
    }
}

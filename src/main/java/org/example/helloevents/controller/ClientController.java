package org.example.helloevents.controller;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.example.helloevents.dto.ClientDto;
import org.example.helloevents.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class ClientController {
    private  ClientService clientService;
    @PostMapping("client")
    private ResponseEntity<ClientDto> save( @RequestBody ClientDto clientDto) {
      ClientDto saved = clientService.save(clientDto);
      return ResponseEntity.ok(saved);
    }
    @GetMapping("clients")
    private ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }
    @GetMapping("{id}")
    private ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ClientDto> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("{id}")
    private ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        ClientDto saved = clientService.update(id, clientDto);
        return ResponseEntity.ok(saved);
    }

}

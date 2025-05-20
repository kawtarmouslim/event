package org.example.helloevents.services;

import lombok.AllArgsConstructor;
import org.example.helloevents.dto.ClientDto;
import org.example.helloevents.entites.Client;
import org.example.helloevents.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    public ClientDto save(ClientDto clientDto) {
        Client client=modelMapper.map(clientDto,Client.class);
        Client saved =clientRepository.save(client);
        return modelMapper.map(saved,ClientDto.class);
    }
    public List<ClientDto> findAll() {
        List<Client> clients=clientRepository.findAll();
        return clients.stream()
                .map(client->modelMapper
                        .map(client,ClientDto.class))
                .collect(Collectors.toList());
    }
    public ClientDto findById(Long id) {
        Client client =clientRepository.findById(id).get();
        return modelMapper.map(client,ClientDto.class);
    }
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    public ClientDto update(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id).get();
         client.setNom(clientDto.getNom());
         client.setEmail(clientDto.getEmail());
         client.setPassword(clientDto.getPassword());
         Client saved =clientRepository.save(client);
         return modelMapper.map(saved,ClientDto.class);

    }
}


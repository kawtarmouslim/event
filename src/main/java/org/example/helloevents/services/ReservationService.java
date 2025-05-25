package org.example.helloevents.services;

import lombok.AllArgsConstructor;
import org.example.helloevents.dto.ClientDto;
import org.example.helloevents.dto.ResrvationDto;
import org.example.helloevents.entites.Client;
import org.example.helloevents.entites.Evenement;
import org.example.helloevents.entites.Resrvation;
import org.example.helloevents.repository.ClientRepository;
import org.example.helloevents.repository.EvenementRepository;
import org.example.helloevents.repository.ResrvationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class ReservationService {
    public ReservationService(ResrvationRepository resrvationRepository, ClientRepository clientRepository, EvenementRepository evenementRepository, ModelMapper modelMapper) {
        this.resrvationRepository = resrvationRepository;
        this.clientRepository = clientRepository;
        this.evenementRepository = evenementRepository;
        this.modelMapper = modelMapper;
    }

    private final ResrvationRepository resrvationRepository;
    private final ClientRepository clientRepository;
    private final EvenementRepository evenementRepository;
    private ModelMapper modelMapper;
    public ResrvationDto resrvation(ResrvationDto resrvationDto) {
        Client client=clientRepository.findById(resrvationDto.getIdClient())
                .orElseThrow(()-> new RuntimeException("Client not found"));
        Evenement evenement=evenementRepository.findById(resrvationDto.getIdEvenement())
                .orElseThrow(()-> new RuntimeException("Event not found"));
        Resrvation resrvation=modelMapper.map(resrvationDto, Resrvation.class);
        resrvation.setClient(client);
        resrvation.setEvent(evenement);
        Resrvation rserver=resrvationRepository.save(resrvation);
        ResrvationDto dto=modelMapper.map(rserver, ResrvationDto.class);
        dto.setIdClient(resrvationDto.getIdClient());
        dto.setIdEvenement(resrvationDto.getIdEvenement());
        return dto;
    }

}

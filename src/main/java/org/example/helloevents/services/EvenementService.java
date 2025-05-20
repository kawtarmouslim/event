package org.example.helloevents.services;

import lombok.AllArgsConstructor;
import org.example.helloevents.dto.EvenementDto;
import org.example.helloevents.entites.Evenement;
import org.example.helloevents.repository.EvenementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class EvenementService {
    private  final EvenementRepository evenementRepository;
    private ModelMapper modelMapper;
    public EvenementDto save( EvenementDto evenementDto) {
        Evenement evenement= modelMapper.map(evenementDto,Evenement.class);
        Evenement saved =evenementRepository.save(evenement);
        return modelMapper.map(saved,EvenementDto.class);
    }
    public List<EvenementDto> findAll() {
        List<Evenement> evenements=evenementRepository.findAll();
       return evenements.stream()
               .map(evenement -> modelMapper.map(evenement,EvenementDto.class))
               .toList();
    }
    public EvenementDto finById( Long id) {
        Evenement evenement=evenementRepository.findById(id).get();
        return modelMapper.map(evenement,EvenementDto.class);
    }
    public EvenementDto update( Long id,  EvenementDto evenementDto) {
        Evenement evenement=evenementRepository.findById(id).get();
        evenement.setDescription(evenementDto.getDescription());
        evenement.setTitre(evenementDto.getTitre());
        evenement.setType(evenementDto.getType());
        evenement.setNombrePlase(evenementDto.getNombrePlase());
        evenement.setDateFin(evenementDto.getDateFin());
        evenement.setDateDebut(evenementDto.getDateDebut());
        Evenement update=evenementRepository.save(evenement);
        return modelMapper.map(update,EvenementDto.class);
    }
    public void delete( Long id) {
        evenementRepository.deleteById(id);
    }


}

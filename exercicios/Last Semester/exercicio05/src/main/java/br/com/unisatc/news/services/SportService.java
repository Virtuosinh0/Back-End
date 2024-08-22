package br.com.unisatc.news.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.unisatc.news.controllers.SportController;
import br.com.unisatc.news.dtos.SportRecordDTO;
import br.com.unisatc.news.models.SportEntity;
import br.com.unisatc.news.repositories.SportRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public ResponseEntity<SportEntity> saveSport(SportRecordDTO sportRecordDTO) {
        SportEntity sportEntity = new SportEntity();
        BeanUtils.copyProperties(sportRecordDTO, sportEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(sportRepository.save(sportEntity));
    }

    public ResponseEntity<List<SportEntity>> getAllSports() {
        List<SportEntity> sports = sportRepository.findByDataDesc();
        if(!sports.isEmpty()) {
            for(SportEntity sportEntity : sports) {
                Long sport_id = sportEntity.getSport_id();
                sportEntity.add(linkTo(methodOn(SportController.class).getOneSport(sport_id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(sports);
    }

    public ResponseEntity<Object> getOneSport(Long sport_id) {
        Optional<SportEntity> sport = sportRepository.findById(sport_id);
        if(sport.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum esporte com este id");
        }
        sport.get().add(linkTo(methodOn(SportController.class).getAllSports()).withRel("Lista de esportes"));
        return ResponseEntity.status(HttpStatus.OK).body(sport);
    }

    public ResponseEntity<Object> updateSport(Long sport_id, SportRecordDTO sportRecordDTO) {
        Optional<SportEntity> sport = sportRepository.findById(sport_id);
        if(sport.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum esporte com este id");
        }
        SportEntity sportEntity = sport.get();
        BeanUtils.copyProperties(sportRecordDTO, sportEntity);
        return ResponseEntity.status(HttpStatus.OK).body(sportRepository.save(sportEntity));
    }

    public ResponseEntity<Object> deleteSport(Long sport_id) {
        Optional<SportEntity> sport = sportRepository.findById(sport_id);
        if(sport.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum esporte com este id");
        }
        sportRepository.delete(sport.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

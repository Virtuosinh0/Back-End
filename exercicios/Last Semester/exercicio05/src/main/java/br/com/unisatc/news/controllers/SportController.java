package br.com.unisatc.news.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisatc.news.dtos.SportRecordDTO;
import br.com.unisatc.news.models.SportEntity;
import br.com.unisatc.news.services.SportService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("sport")
public class SportController {
    @Autowired
    private SportService sportService;

    @PostMapping
    public ResponseEntity<SportEntity> saveSport(@RequestBody @Valid SportRecordDTO sportRecordDTO) {
        return sportService.saveSport(sportRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<SportEntity>> getAllSports() {
        return sportService.getAllSports();
    }

    @GetMapping("{sport_id}")
    public ResponseEntity<Object> getOneSport(@PathVariable(value = "sport_id")Long sport_id) {
        return sportService.getOneSport(sport_id);
    }

    @PutMapping("{sport_id}")
    public ResponseEntity<Object> updateSport(@PathVariable(value = "sport_id")Long sport_id, @RequestBody @Valid SportRecordDTO sportRecordDTO) {
        return sportService.updateSport(sport_id, sportRecordDTO);
    }

    @DeleteMapping("{sport_id}")
    public ResponseEntity<Object> deleteSport(@PathVariable(value = "sport_id")Long sport_id) {
        return sportService.deleteSport(sport_id);
    }
}

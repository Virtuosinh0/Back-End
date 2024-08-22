package br.com.unisatc.news.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SportRecordDTO(
    @NotBlank(message = "Campo titulo não pode estar vazio") String sport_title,
    @NotBlank(message = "Campo nome de time não pode estar vazio") String sport_team,
    @NotNull(message = "O campo data não pode estar nulo") @JsonFormat(pattern = "dd/MM/yyyy") LocalDate sport_date

) {
    
}

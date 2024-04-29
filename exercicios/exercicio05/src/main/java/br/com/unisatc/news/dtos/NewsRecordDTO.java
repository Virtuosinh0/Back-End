package br.com.unisatc.news.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewsRecordDTO(
    @NotBlank(message = "Titulo não pode estar vazio.") String news_title,
    @NotBlank(message = "Pais não pode estar vazio.") String news_country,
    @NotNull(message = "Data não pode estar vazio") 
    @JsonFormat(pattern = "dd/MM/yyyy") LocalDate news_date
) {
    
}

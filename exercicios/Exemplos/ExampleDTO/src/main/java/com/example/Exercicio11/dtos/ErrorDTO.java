package com.example.Exercicio11.dtos;

import org.springframework.http.HttpStatus;

public record ErrorDTO(
        HttpStatus status,
        String mensagem
) {
}

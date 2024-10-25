package com.example.Exercicio11.dtos;

import jakarta.validation.constraints.*;

public record PlayerRequestDTO(
        @NotBlank @Size(min = 5, max = 100, message = "Skill Issue") String name,
        @NotNull String alias,
        @NotNull String position,
        @Min(value = 18) @Max(value = 100) Integer age
) {}

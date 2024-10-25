package com.example.Exercicio11.mapper;

import com.example.Exercicio11.dtos.PlayerResponseDTO;
import com.example.Exercicio11.models.PlayerModel;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerResponseDTO toDTO(PlayerModel player){
        return new PlayerResponseDTO(
                player.getName(),
                player.getHability()
        );
    }
}

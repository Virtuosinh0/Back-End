package com.example.Exercicio11.service;

import com.example.Exercicio11.dtos.PlayerRequestDTO;
import com.example.Exercicio11.dtos.PlayerResponseDTO;
import com.example.Exercicio11.mapper.PlayerMapper;
import com.example.Exercicio11.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class PlayerService {
    public ArrayList<PlayerModel> playersList;

    @Autowired
    PlayerMapper playerMapper;

    public PlayerResponseDTO insertPlayer(PlayerRequestDTO playerRequestDTO){
        PlayerModel player = new PlayerModel();
        Integer randomAbility = new Random().nextInt(1,100);

        player.setName(playerRequestDTO.name());
        player.setAlias(playerRequestDTO.alias());
        player.setPosition(playerRequestDTO.position());
        player.setAge(playerRequestDTO.age());
        player.setHability(randomAbility);

        playersList.add(player);

        return playerMapper.toDTO(player);
    }
}

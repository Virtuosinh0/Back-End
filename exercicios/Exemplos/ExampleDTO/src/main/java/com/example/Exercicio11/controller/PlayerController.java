package com.example.Exercicio11.controller;

import com.example.Exercicio11.dtos.ErrorDTO;
import com.example.Exercicio11.dtos.PlayerRequestDTO;
import com.example.Exercicio11.dtos.PlayerResponseDTO;
import com.example.Exercicio11.service.PlayerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/jogador")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponseDTO insertPlayer(@RequestBody @Valid PlayerRequestDTO player){
        return playerService.insertPlayer(player);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO ExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException exception){
        return new ErrorDTO(HttpStatus.BAD_REQUEST,
                exception.getAllErrors().get(0).getDefaultMessage()
                );
    }
}

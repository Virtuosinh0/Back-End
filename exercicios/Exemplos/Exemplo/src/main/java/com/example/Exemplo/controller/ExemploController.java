package com.example.Exemplo.controller;

import com.example.Exemplo.models.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class ExemploController {

    @GetMapping("/mundo")
    public String ola(@RequestParam String Nome, @RequestParam String Sobrenome){
        return "Olá " + Nome + " " + Sobrenome;
    }

    @PostMapping("/mundo")
    public  String jogador(){
        return "Post";
    }

    @PostMapping("/pessoa")
    public  String pessoa(@RequestBody Pessoa usuario){
        return "Usuario: " + usuario.getNome() + " " + usuario.getSobrenome();
    }

    @GetMapping("/copia")
    @ResponseBody
    public String copiar() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/mundo?Nome=Virtuoso&Sobrenome=Silvio"))
                .header("User-Agent", "insomnia/8.4.5")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

}

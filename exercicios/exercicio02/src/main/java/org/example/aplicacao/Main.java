package org.example.aplicacao;

import org.example.jogo.Item;
import org.example.jogo.Jogador;
import org.example.jogo.Bloco;
import org.example.jogo.FerroBloco;

import java.security.Key;

public class Main {
    public static void main(String[] args) {

        Jogador Virtuoso = new Jogador();
        Item KeyItem = new Item();
        FerroBloco BlocoDeFerro = new FerroBloco("Minério de Ferro");

        KeyItem.setNome("Machado");

        System.out.println(Virtuoso.Nick());


        Virtuoso.Mover(5,5);
        System.out.println(Virtuoso.Location());
        System.out.println(KeyItem.getNome());

        Item drop = BlocoDeFerro.destruir();

        if (drop == null){
            System.out.println("Nada dropado");
        }
        else {
            System.out.println(drop.getNome());
        }
    }
}
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Personagem jogador = new Personagem();
        jogador.Nome = "Silvio";
        Personagem ini1 = new Personagem();
        ini1.Nome = "Slime nenenoso";
        Personagem ini2 = new Personagem();
        ini2.Nome = "Slime Acido";

        for (int i = 1; i <= 10; i++) {
            jogador.atacarAlvo(ini1);
            System.out.println(ini1.Saude());
        }
    }
}
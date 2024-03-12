package org.example.jogo;

import java.sql.Struct;

public class Jogador {
    private String Nome = "Virtuoso";
    private int EixoX = 0;
    private int EixoY = 0;

    public void Mover(int x, int y){
        EixoX = x;
        EixoY = y;
    }

    public String Nick(){
        return Nome;
    }

    public String Location(){
        return EixoX + " / " + EixoY;
    }

}

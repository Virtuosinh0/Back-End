package org.example;

public class Kamikaze extends Personagem {
    @Override
    public void atacarAlvo(Personagem inimigo){
        inimigo.receberDano(20);
        this.receberDano(20);
    }
}

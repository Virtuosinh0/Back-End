package org.example;

public class Personagem {
    public String Nome;
    private Integer Vida = 10;
    private Integer Dano = 1;

    public void receberDano(int Dano){
        if(Vida > Dano)
            Vida -= Dano;
        else
            Vida = 0;
            System.out.println("O personagem " + Nome + " foi derrotado!");
    }

    public int Saude(){
        return Vida;
    }

    public void atacarAlvo(Personagem inimigo){
        if(inimigo.Vida > 0)
            inimigo.receberDano(Dano);
        else
            System.out.println(inimigo.Nome+ " já está derrotado!");
    }

}

package org.example;

public class PortoGrande extends BasePorto{
    @Override
    public void AtracarBarco(Barco Entrada){
        if(Entrada.Tamanho > 10) {
            BarcosAtracados.add(Entrada);
        }
        else{
            System.out.println("O barco é muito pequeno!");
        }
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasePorto {
    public String Nome;
    List<Barco> BarcosAtracados = new ArrayList<Barco>();

    public void AtracarBarco(Barco Entrada){
        BarcosAtracados.add(Entrada);
    }

    public void DesatracarBarco(Barco Saida){
        BarcosAtracados.remove(Saida);
    }
}

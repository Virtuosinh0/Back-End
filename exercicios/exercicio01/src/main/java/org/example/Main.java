package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static String retornaListaDaURI(String minhaUri) throws Exception{
        // Puxando o arquivo de texto usando HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String lista = response.body();
        return lista;
    }

    public static String retornaIndiceAleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    public static int GeraNumeroAleatorio(int Menor, int Maior){
        int Diferenca = Maior - Menor + 1;
        int Numero = (int) Math.floor(Math.random() * Diferenca);
        int NumeroAleatorio = Numero + Menor;
        return NumeroAleatorio;
    }

    public static void main(String[] args) throws Exception {
        int idade = GeraNumeroAleatorio(17,40);

        String listaDeNomes = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        String nome = retornaIndiceAleatorio(listaDeNomes);

        String listaDeSobrenomes = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);

        String listaDePosicoes = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        String posicao = retornaIndiceAleatorio(listaDePosicoes);
        posicao = posicao.replace("\"","");

        String listaDeClubes = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
        String clube = retornaIndiceAleatorio(listaDeClubes);

        //System.out.println(nome + " " + sobrenome);
        //System.out.printf("%s %s", nome, sobrenome);
        /*
        System.out.println(nome);
        System.out.println(sobrenome);
        System.out.println(posicao);
        System.out.println(clube);
        */
        System.out.println(
                nome
                + " "
                + sobrenome
                + " de "
                + idade
                + " anos de idade,"
                + " joga na posição de "
                + posicao
                + " no time "
                + clube
        );
    }
}
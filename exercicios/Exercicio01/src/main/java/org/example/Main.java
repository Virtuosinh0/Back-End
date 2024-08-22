package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[][] lista = {{"Homens de Preto", "Arrival"},{"Shrek", "Gladiador"}};

        System.out.println("Que ambientacao voce prefere");
        System.out.println("1 - Sci-fi");
        System.out.println("2 - Medieval");
        Integer op1 = leitor.nextInt();

        System.out.println("Que genero voce prefere");
        System.out.println("1 - Comedia");
        System.out.println("2 - Drama");
        Integer op2 = leitor.nextInt();

        System.out.println(lista[op1-1][op2-1]);
    }
}
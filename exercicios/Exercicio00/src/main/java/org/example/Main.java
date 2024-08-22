package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String primeiroNome = leitor.nextLine();
        if (primeiroNome == "") return;
        String segundoNome = leitor.nextLine();

        Random geradorAleatorio = new Random();
        Integer codigoUsuario = geradorAleatorio.nextInt(1, 100);
        System.out.println(primeiroNome + segundoNome + codigoUsuario);

    }
}
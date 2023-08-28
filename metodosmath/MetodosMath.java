package metodosmath;

import java.awt.DisplayMode;

public class MetodosMath {

    public static void main(String[] args) {

        int inicio = 1000;
        int fim = 2000;

        exibirNumeros(inicio, fim);

    }

    public static void exibirNumeros(int inicio, int fim) {

        inicio = Math.min(inicio, 1000);
        fim = Math.min(fim, 2000);

        for (int i = inicio; i <= fim; i++) {
            System.out.println(i);

        }

    }

}



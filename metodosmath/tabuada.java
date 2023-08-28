package metodosmath;

import javax.swing.JOptionPane;

public class tabuada {

    public static void main(String[] args) {

        int numeroTabuada;

        numeroTabuada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da tabuada que você deseja ver: ", "TABUADA", JOptionPane.PLAIN_MESSAGE));

        printTabuada(numeroTabuada);

    }

    public static void printTabuada(int numero) {

        System.out.println("Tabuada do " + numero + ":");

        for (int i = 1; i <= 10; i++) {

            int resultado = numero * i;

            System.out.println(numero + " x " + i + " = " + resultado);
        }

    }

}

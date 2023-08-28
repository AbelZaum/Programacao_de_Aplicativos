package metodosmath;

import javax.swing.JOptionPane;

public class quadrados {

    public static void main(String[] args) {

        int userNumero;
        int soma;

        userNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número maior que 0 e menor que 10: ", "INSIRA", JOptionPane.PLAIN_MESSAGE));

        if (userNumero > 0 && userNumero < 10) {
            soma = calcularQuadrado(userNumero);

            JOptionPane.showMessageDialog(null, "A soma dos quadrados dos primeiros 20 números ímpares a partir de " + userNumero + " é: " + soma);

        } else {

            JOptionPane.showMessageDialog(null, "Número inválido. O número deve ser maior que 0 e menor que 10.", "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static int calcularQuadrado(int inicioNumero) {

        int soma = 0;
        int contador = 0;

        while (contador < 20) {

            if (inicioNumero % 2 != 0) { //verificar se é impar
                soma += Math.pow(inicioNumero, 2); // Calcula o quadrado e adiciona à soma
                contador++;

            }

            inicioNumero++;

        }

        return soma;

    }

}

package math;

import javax.swing.JOptionPane;

public class mediaNumeros {

    public static void main(String[] args) {

        int cont = 1, numero;
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, media = 0;

        for (int i = 0; cont <= 10; i++) {

            numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um valor positivo: "));

            if (numero > 0) {

                maior = Math.max(numero, maior);
                menor = Math.min(numero, menor);
                System.out.println(cont + "° ");
                System.out.println("O maior é: " + maior);
                System.out.println(", O menor é: " + menor + "\n");

                media += numero;
                cont++;
            } else {

                JOptionPane.showMessageDialog(null, "Informe um valor válido, positivo");

            }
        }
    }
}

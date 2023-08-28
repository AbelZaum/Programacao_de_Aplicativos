package math;

import javax.swing.JOptionPane;

public class maiorMenor {

    public static void main(String[] args) {

        String op = "Sim";
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;

        do {

            int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero: "));

            menor = Math.min(numero, menor);
            maior = Math.max(numero, maior);

            JOptionPane.showMessageDialog(null, "O menor valor é: " + menor + ""
                    + "\n O maior valor digitado é: " + maior);
            op = JOptionPane.showInputDialog("Deseja sair?\n Sim\nNão");
        } while (!op.equalsIgnoreCase("Sim"));

    }
}

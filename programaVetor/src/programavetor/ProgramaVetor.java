package programavetor;

import javax.swing.JOptionPane;

public class ProgramaVetor {

    private static int[] vetor;
    private static int tamanho;

    public static void main(String[] args) {

        int escolha;

        while (true) {

            escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma Opção:\n "
                    + "1 - Carregar vetor\n "
                    + "2 - Listar vetor\n"
                    + "3 - Exibir apenas os numeros pares do vetor\n"
                    + "4 - Exibir apenas os numeros impares do vetor\n"
                    + "5 - Exibir a quantidade de numeros pares nas posições impares\n"
                    + "6 - Exibir a quantidade de numeros impares nas posições pares\n"
                    + "7 - Sair do programa", "ESCOLHA", JOptionPane.PLAIN_MESSAGE));

            switch (escolha) {
                case 1:
                    carregarVetor();
                    break;

                case 2:
                    listarVetor();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Saindo do programa", "ENCERRANDO", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida, tente novamente!!");

                    break;
            }

        }

    }

    public static void carregarVetor() {

        vetor = new int[tamanho];

        tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tamanho do vetor", "INFORME", JOptionPane.PLAIN_MESSAGE));

        for (int i = 0; i < tamanho; i++) {

            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do vetor: " + i + ":"));

        }
    }

    public static void listarVetor() {
        
        
    }
    
    
    
    
}

package programavetor;

import javax.swing.JOptionPane;

public class ProgramaVetor {

    static int[] vetor;
    static int tamanho;

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
                    exibirPares();
                    break;
                case 4:
                    exibirImpares();
                    break;
                case 5:
                    contarParesPosicoesImpares();
                    break;
                case 6:
                    contarImparesPosicoesPares();
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

        tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tamanho do vetor", "INFORME", JOptionPane.PLAIN_MESSAGE));
        vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {

            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do vetor: " + i + ":"));

        }
    }

    public static void listarVetor() {

        if (vetor == null) {

            JOptionPane.showMessageDialog(null, "O vetor nao foi carregado ainda", "LISTA", JOptionPane.ERROR_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Conteudo do vetor:", "LISTA", JOptionPane.PLAIN_MESSAGE);
        }
        for (int i = 0; i < tamanho; i++) {

            JOptionPane.showMessageDialog(null, vetor[i] + "");
        }

    }

    public static void exibirPares() {

        JOptionPane.showMessageDialog(null, "Numeros pares do vetor", "PARES", JOptionPane.PLAIN_MESSAGE);

        for (int i = 0; i < tamanho; i++) {

            if (vetor[i] % 2 == 0) {

                JOptionPane.showMessageDialog(null, vetor[i] + "");

            }

        }

    }

    public static void exibirImpares() {

        JOptionPane.showMessageDialog(null, "Numeros impares do vetor", "IMPARES", JOptionPane.PLAIN_MESSAGE);

        for (int i = 0; i < tamanho; i++) {

            if (vetor[i] % 2 != 0) {

                JOptionPane.showMessageDialog(null, vetor[i] + "");

            }
        }

    }

    public static void contarParesPosicoesImpares() {

        int cont = 0;

        for (int i = 1; i < tamanho; i += 2) {

            if (vetor[i] % 2 == 0) {

                cont++;
        
            }

        }

        JOptionPane.showMessageDialog(null, "Quantidades de numeros pares nas posições impares: " + cont);
        
    }

    public static void contarImparesPosicoesPares() {

        int cont = 0;

        for (int i = 1; i < tamanho; i += 2) {

            if (vetor[i] % 2 == 0) {

                cont++;

            }

        }

        JOptionPane.showMessageDialog(null, "Quantidades de numeros impares nas posições pares: " + cont);

    }
}
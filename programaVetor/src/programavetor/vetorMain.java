package programavetor;

import javax.swing.JOptionPane;
import static programavetor.ProgramaVetor.carregarVetor;
import static programavetor.ProgramaVetor.contarImparesPosicoesPares;
import static programavetor.ProgramaVetor.contarParesPosicoesImpares;
import static programavetor.ProgramaVetor.exibirImpares;
import static programavetor.ProgramaVetor.exibirPares;
import static programavetor.ProgramaVetor.listarVetor;

public class vetorMain {

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

}

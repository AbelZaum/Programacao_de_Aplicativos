package metodojavastring;

import javax.swing.JOptionPane;

public class ReplaceMetodo {

    public static void main(String[] args) {
        
        // trocando de String
        String frase = JOptionPane.showInputDialog("Informe uma frase: ");

        JOptionPane.showMessageDialog(null, "Trocando caracteres da palavra: \n" + frase + ""
                + "o 'a' por 'u'\n " + frase.replace("a", "u"));
        
        // tirando espaços vazios
        JOptionPane.showMessageDialog(null, "Tirando os espaços vazios da palavra: "
                + "\n" + frase + "\n " + frase.replace(" ", ""));

        // trocando vetor
        String[] cores = {"azul", "amarelo", "laranja"};
        
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "Trocando caracteres 'a' por 'u' da palavra no vetor: "
                    + "\n" + cores[i] + " \n " + cores[i].replace("a", "u"));

        }
        // conta quantidade de caracteres
        int qtd = frase.length();

        JOptionPane.showMessageDialog(null, "quantidade de espaços da frase " + qtd);

    }
}
package metodojavastring;

import javax.swing.JOptionPane;

public class agenda {

    public static void main(String[] args) {

        String[] nomescompletos = {"João silva", "Maria santos", "Pedro oliveira", "Ana souza", "Luiz pereira", "Fernanda almeida", "Carlos rodrigues", "Rafaela lima", "Marcos Costa", "Abel machado"};

        String sobrenomeProcurado = JOptionPane.showInputDialog("Qual sobrenome você procura?");

        // VARIAVEL PARA VERIFICAR SE O SOBRENOME FOI ENCONTRADO
        boolean encontrado = false;
        // REPETINDO O ARRAY PARA ENCONTRAR OS NOME 
        for (String nomeCompleto : nomescompletos) {
            // VERIFICA SE O NOME COMPLETO TERMINA COM O SOBRENOME PROCURADO
            if (nomeCompleto.endsWith(sobrenomeProcurado)) {

                JOptionPane.showMessageDialog(null, "nome completo da pessoa: " + nomeCompleto);
                encontrado = true;
                // MARCA QUE O SOBRENOME FOI ENCONTRADO
            }

        }
        // SE NAO ENCONTRAR NENHUM SOBRENOME
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Nenhum nome encontrado na lista!");

        }

        //----------------------------------------------------------------------------------  
        String nomeProcurado = JOptionPane.showInputDialog("Qual nome você procura?");

        boolean achado = false;
        // REPETINDO O ARRAY PARA ENCONTRAR OS NOME 
        for (String nomescompleto : nomescompletos) {
            // VERIFICA SE O NOME COMPLETO TERMINA COM O SOBRENOME PROCURADO
            if (nomescompleto.startsWith(nomeProcurado)) {

                JOptionPane.showMessageDialog(null, "nome completo da pessoa: " + nomescompleto);
                achado = true;
                // MARCA QUE O SOBRENOME FOI ENCONTRADO
            }

        }
        // SE NAO ENCONTRAR NENHUM SOBRENOME
        if (!achado) {
            JOptionPane.showMessageDialog(null, "Nenhum nome encontrado na lista!");

        }

    }
}
package metodos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

class Pessoa {

    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }
}

public class CadastroDePessoas {

    private List<Pessoa> pessoas = new ArrayList<>();

    public void executar() {
        while (true) {
            String nome = JOptionPane.showInputDialog("Digite o nome da pessoa (ou 'sair' para encerrar):");

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da pessoa:"));
            double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura da pessoa (em metros):"));

            Pessoa pessoa = new Pessoa(nome, idade, altura);
            pessoas.add(pessoa);
        }

        String[] opcoes = {"Por nome", "Por idade", "Por altura"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha como deseja ordenar a lista:", "Ordenar Lista",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha >= 0 && escolha < opcoes.length) {
            switch (escolha) {
                case 0:
                    Collections.sort(pessoas, Comparator.comparing(Pessoa::getNome));
                    break;
                case 1:
                    Collections.sort(pessoas, Comparator.comparingInt(Pessoa::getIdade));
                    break;
                case 2:
                    Collections.sort(pessoas, Comparator.comparingDouble(Pessoa::getAltura));
                    break;
            }

            StringBuilder listaOrdenada = new StringBuilder("Lista ordenada:\n");
            for (Pessoa pessoa : pessoas) {
                listaOrdenada.append("Nome: ").append(pessoa.getNome()).append(", Idade: ").append(pessoa.getIdade())
                        .append(", Altura: ").append(pessoa.getAltura()).append("\n");
            }

            JOptionPane.showMessageDialog(null, listaOrdenada.toString(), "Lista Ordenada", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CadastroDePessoas cadastro = new CadastroDePessoas();
        cadastro.executar();
    }
}
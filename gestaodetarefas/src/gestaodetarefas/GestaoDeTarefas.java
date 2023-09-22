package gestaodetarefas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

// Classe que representa uma tarefa
class Tarefa {

    String titulo;
    String descricao;
    Date dataVencimento;

    // Construtor da classe Tarefa
    public Tarefa(String titulo, String descricao, Date dataVencimento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
    }

    public String getTitulo() {

        return titulo;

    }

    public String getDescricao() {

        return descricao;

    }

    public Date getDataVencimento() {

        return dataVencimento;

    }

}

public class GestaoDeTarefas {

    static ArrayList<Tarefa> listaTarefas = new ArrayList<>();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        while (true) {
            // Array de opções para o menu
            Object[] opcoes = {"Cadastro de Tarefas", "Vizualizar Tarefas", "Atualizar a Tarefa", "Excluir Tarefa", "Data de Vencimento das Tarefas", "Sair"};

            // Exibe um menu de escolha
            Object escolha = JOptionPane.showInputDialog(null, "Sistema de Gestão de Tarefas", "Menu", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            String escolhaOpcao = (String) escolha;

            switch (escolhaOpcao) {
                case "Cadastro de Tarefas":
                    cadastrarTarefa();

                    break;
                case "Vizualizar Tarefas":
                    listarTarefas();
                    break;
                case "Atualizar a Tarefa":
                    atualizarTarefa();
                    break;

                case "Excluir Tarefa":
                    excluirTarefa();
                    break;

                case "Data de Vencimento das Tarefas":
                    VencimentoTarefas();
                    break;

                case "Sair":
                    // Exibe mensagem de saída e encerra o programa
                    JOptionPane.showMessageDialog(null, "Saindo do Programa!", "ENCERRANDO", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                // Lida com escolhas inválidas (não faz nada neste caso)
            }

        }

    }

    public static void cadastrarTarefa() {
        // Solicita ao usuário as informações da nova tarefa
        String titulo = JOptionPane.showInputDialog("Digite o título da tarefa:");
        String descricao = JOptionPane.showInputDialog("Digite a descrição da tarefa:");
        String dataStr = JOptionPane.showInputDialog("Digite a data de vencimento (dd/MM/yyyy):");

        try {
            // Tenta converter a string de data em um objeto Date
            Date dataVencimento = dateFormat.parse(dataStr);

            // Cria um objeto Tarefa com as informações fornecidas
            Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento);

            // Adiciona a tarefa à lista de tarefas
            listaTarefas.add(tarefa);

            JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso.");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar tarefa. Verifique a data.");
        }
    }

    public static void listarTarefas() {
        // Se a lista de tarefas estiver vazia, exibe uma mensagem informativa
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas");
            return;
        }

        // Constrói uma lista formatada com todas as tarefas cadastradas
        StringBuilder lista = new StringBuilder("Lista de Tarefas:\n");

        for (Tarefa tarefa : listaTarefas) {
            lista.append("Título: ").append(tarefa.getTitulo()).append("\n");
            lista.append("Descrição: ").append(tarefa.getDescricao()).append("\n");
            lista.append("Data de Vencimento: ").append(dateFormat.format(tarefa.getDataVencimento())).append("\n\n");
        }
        // Exibe a lista de tarefas    
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public static void atualizarTarefa() {
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas para atualizar");
            return;
        }

        String tituloParaAtualizar = JOptionPane.showInputDialog("Digite o título da tarefa que deseja atualizar:");

        // Procura a tarefa com o título correspondente na lista
        Tarefa tarefaEncontrada = null;
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(tituloParaAtualizar)) {
                tarefaEncontrada = tarefa;
                break;
            }
        }

        if (tarefaEncontrada == null) {
            JOptionPane.showMessageDialog(null, "Tarefa não encontrada");

        }

        // Solicita as novas informações da tarefa
        String novoTitulo = JOptionPane.showInputDialog("Digite o novo título da tarefa:");
        String novaDescricao = JOptionPane.showInputDialog("Digite a nova descrição da tarefa:");
        String novaDataStr = JOptionPane.showInputDialog("Digite a nova data de vencimento (dd/MM/yyyy):");

        try {
            // Tenta converter a string de data em um objeto Date
            Date novaDataVencimento = dateFormat.parse(novaDataStr);

            // Atualiza os detalhes da tarefa
            tarefaEncontrada.titulo = novoTitulo;
            tarefaEncontrada.descricao = novaDescricao;
            tarefaEncontrada.dataVencimento = novaDataVencimento;

            JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tarefa. Verifique a nova data");
        }
    }

    public static void excluirTarefa() {
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas para excluir");
            return;
        }

        String tituloParaExcluir = JOptionPane.showInputDialog("Digite o título da tarefa que deseja excluir:");

        // Procura a tarefa com o título correspondente na lista
        Tarefa tarefaEncontrada = null;
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(tituloParaExcluir)) {
                tarefaEncontrada = tarefa;
                break;
            }
        }

        if (tarefaEncontrada == null) {
            JOptionPane.showMessageDialog(null, "Tarefa não encontrada");
            return;
        }

        // Remove a tarefa da lista
        listaTarefas.remove(tarefaEncontrada);

        JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso");
    }

    public static void VencimentoTarefas() {
        // Se a lista de tarefas estiver vazia, exibe uma mensagem informativa
        if (listaTarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas");
            return;
        }
        //Cria um objeto que verifica a data atual do computador
        Date dataAtual = new Date();

        // Constrói uma lista formatada com as tarefas vencidas
        StringBuilder tarefasVencidas = new StringBuilder("Tarefas Vencidas:\n");
        //Cria uma variavel String 

        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getDataVencimento().before(dataAtual)) {
                tarefasVencidas.append("Título: ").append(tarefa.getTitulo()).append("\n");
                tarefasVencidas.append("Descrição: ").append(tarefa.getDescricao()).append("\n");
                tarefasVencidas.append("Data de Vencimento: ").append(dateFormat.format(tarefa.getDataVencimento())).append("\n\n");
            }
        }

        if (tarefasVencidas.length() > 0) {
            JOptionPane.showMessageDialog(null, tarefasVencidas.toString(), "Tarefas Vencidas", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não há tarefas vencidas");
        }
    }
}

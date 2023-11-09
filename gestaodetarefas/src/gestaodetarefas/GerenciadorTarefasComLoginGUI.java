package gestaodetarefas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorTarefasTrelloGUI {

    private JFrame frame;
    private JComboBox<String> colunaComboBox;
    private JButton moverTarefaButton;
    private JButton adicionarTarefaButton;
    private JButton excluirTarefaButton;  // Novo botão para excluir tarefa
    private JTextField nomeTarefaField;
    private JTextField descricaoTarefaField;
    private JTextField dataVencimentoField;
    private Map<String, DefaultTableModel> colunaTabelas;
    private Map<String, List<Tarefa>> colunasTarefas;

    public GerenciadorTarefasTrelloGUI() {
        frame = new JFrame("Gerenciador de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);

        colunaTabelas = new HashMap<>();
        colunasTarefas = new HashMap<>();

        for (String coluna : new String[]{"A fazer", "Em andamento", "Concluídas"}) {
            colunaTabelas.put(coluna, new DefaultTableModel(new String[]{"Nome", "Descrição", "Data de Vencimento"}, 0));
            colunasTarefas.put(coluna, new java.util.ArrayList<>());
        }

        colunaComboBox = new JComboBox<>(new String[]{"A fazer", "Em andamento", "Concluídas"});

        moverTarefaButton = new JButton("Mover Tarefa");
        moverTarefaButton.setBackground(Color.BLUE);
        moverTarefaButton.setForeground(Color.WHITE);
        moverTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverTarefa();
            }
        });

        adicionarTarefaButton = new JButton("Adicionar Tarefa");
        adicionarTarefaButton.setBackground(Color.GREEN);
        adicionarTarefaButton.setForeground(Color.WHITE);
        adicionarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefaAFAzer();
            }
        });

        excluirTarefaButton = new JButton("Excluir Tarefa");  // Inicializa o botão de excluir tarefa
        excluirTarefaButton.setBackground(Color.RED);
        excluirTarefaButton.setForeground(Color.WHITE);
        excluirTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirTarefa();
            }
        });

        nomeTarefaField = new JTextField();
        descricaoTarefaField = new JTextField();
        dataVencimentoField = new JTextField();

        criarInterfacePrincipal();

        frame.setVisible(true);
    }

    private void criarInterfacePrincipal() {
        JPanel painelPrincipal = new JPanel(new GridLayout(1, 3));

        for (String coluna : colunaTabelas.keySet()) {
            JPanel colunaPanel = new JPanel(new BorderLayout());
            colunaPanel.setBorder(BorderFactory.createTitledBorder(coluna));

            JTable tarefaTable = new JTable(colunaTabelas.get(coluna));
            colunaPanel.add(new JScrollPane(tarefaTable), BorderLayout.CENTER);

            painelPrincipal.add(colunaPanel);
        }

        JPanel adicionarPanel = new JPanel(new GridLayout(7, 1));
        adicionarPanel.setBorder(BorderFactory.createTitledBorder("Adicionar Tarefa"));

        adicionarPanel.add(new JLabel("Nome:"));
        adicionarPanel.add(nomeTarefaField);
        adicionarPanel.add(new JLabel("Descrição:"));
        adicionarPanel.add(descricaoTarefaField);
        adicionarPanel.add(new JLabel("Data de Vencimento (dd/MM/yyyy):"));
        adicionarPanel.add(dataVencimentoField);
        adicionarPanel.add(adicionarTarefaButton);

        JPanel controlePanel = new JPanel(new FlowLayout());
        controlePanel.add(colunaComboBox);
        controlePanel.add(moverTarefaButton);
        controlePanel.add(excluirTarefaButton);  // Adiciona o botão de excluir tarefa ao painel de controle

        frame.add(painelPrincipal, BorderLayout.CENTER);
        frame.add(adicionarPanel, BorderLayout.WEST);
        frame.add(controlePanel, BorderLayout.SOUTH);
    }

    private void moverTarefa() {
        String colunaAtual = (String) colunaComboBox.getSelectedItem();
        String proximaColuna = obterProximaColuna(colunaAtual);

        int selectedRow = colunaTabelas.get(colunaAtual).getRowCount() - 1;
        if (selectedRow >= 0 && proximaColuna != null) {
            Tarefa tarefa = colunasTarefas.get(colunaAtual).remove(selectedRow);
            colunasTarefas.get(proximaColuna).add(tarefa);

            colunaTabelas.get(colunaAtual).removeRow(selectedRow);
            colunaTabelas.get(proximaColuna).addRow(new Object[]{tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataVencimentoStr()});
        }
    }

    private void excluirTarefa() {
        String colunaAtual = (String) colunaComboBox.getSelectedItem();
        int selectedRow = colunaTabelas.get(colunaAtual).getRowCount() - 1;
        if (selectedRow >= 0) {
            colunasTarefas.get(colunaAtual).remove(selectedRow);
            colunaTabelas.get(colunaAtual).removeRow(selectedRow);
        }
    }

    private String obterProximaColuna(String colunaAtual) {
        switch (colunaAtual) {
            case "A fazer":
                return "Em andamento";
            case "Em andamento":
                return "Concluídas";
            default:
                return null;
        }
    }

    private void adicionarTarefaAFAzer() {
        String nome = nomeTarefaField.getText();
        String descricao = descricaoTarefaField.getText();
        String dataVencimento = dataVencimentoField.getText();

        if (!nome.isEmpty()) {
            Tarefa tarefa = new Tarefa(nome, descricao, dataVencimento);
            colunasTarefas.get("A fazer").add(tarefa);
            DefaultTableModel tabelaAtual = colunaTabelas.get("A fazer");
            tabelaAtual.addRow(new Object[]{tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataVencimentoStr()});
            nomeTarefaField.setText("");
            descricaoTarefaField.setText("");
            dataVencimentoField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GerenciadorTarefasTrelloGUI());
    }

    class Tarefa {

        private String nome;
        private String descricao;
        private String dataVencimento;

        public Tarefa(String nome, String descricao, String dataVencimento) {
            this.nome = nome;
            this.descricao = descricao;
            this.dataVencimento = dataVencimento;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDataVencimentoStr() {
            return dataVencimento;
        }
    }
}

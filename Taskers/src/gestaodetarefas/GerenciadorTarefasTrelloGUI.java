package gestaodetarefas;

import GestaoDeTarefa.DatabaseConnection;
import GestaoDeTarefa.Login;
import GestaoDeTarefa.Tarefa;
import GestaoDeTarefa.TarefaDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class GerenciadorTarefasTrelloGUI {

    private JFrame frame;
    private JComboBox<String> colunaComboBox;
    private JButton moverTarefaButton;
    private JButton adicionarTarefaButton;
    private JButton excluirTarefaButton;
    private JTextField nomeTarefaField;
    private JTextField descricaoTarefaField;
    private JTextField dataVencimentoField;
    private Map<String, DefaultTableModel> colunaTabelas;
    private Map<String, List<Tarefa>> colunasTarefas;
    private static GerenciadorTarefasTrelloGUI gerenciadorTarefasGUI;
    private TarefaDAO tarefaDAO;
    private int idUsuario;

    public GerenciadorTarefasTrelloGUI(int idUsuario) {
        this.idUsuario = idUsuario;
        tarefaDAO = new TarefaDAO();

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

        excluirTarefaButton = new JButton("Excluir Tarefa");
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

    public static void iniciarSistemaTarefas() {
        gerenciadorTarefasGUI = new GerenciadorTarefasTrelloGUI(0);
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
        controlePanel.add(excluirTarefaButton);

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
            colunaTabelas.get(proximaColuna).addRow(new Object[]{tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataVencimento()});
        }
    }

    private void excluirTarefa() {
        String colunaAtual = (String) colunaComboBox.getSelectedItem();
        int selectedRow = colunaTabelas.get(colunaAtual).getRowCount() - 1;
        if (selectedRow >= 0) {
            Tarefa tarefa = colunasTarefas.get(colunaAtual).remove(selectedRow);
            colunaTabelas.get(colunaAtual).removeRow(selectedRow);
            // Aqui vamos chamar um método para excluir a tarefa do banco de dados
            excluirTarefaDoBancoDeDados(tarefa);
        }
    }

    private String obterProximaColuna(String colunaAtual) {
        switch (colunaAtual) {
            case "A fazer":
                return "Em andamento";
            case "Em andamento":
                return "Concluídas";
            case "Concluídas":
                return "A fazer";
            default:
                return null;
        }
    }

    private void adicionarTarefaAFAzer() {
        String nome = nomeTarefaField.getText();
        String descricao = descricaoTarefaField.getText();
        String dataVencimentoStr = dataVencimentoField.getText();

        if (!nome.isEmpty() && !dataVencimentoStr.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataVencimento;
            try {
                dataVencimento = dateFormat.parse(dataVencimentoStr);

                Tarefa tarefa = new Tarefa(nome, descricao, dataVencimento);
                tarefa.setIdUsuario(idUsuario); // Associe o ID do usuário à tarefa

                tarefa.setStatus("A fazer");
                colunasTarefas.get("A fazer").add(tarefa);
                DefaultTableModel tabelaAtual = colunaTabelas.get("A fazer");
                tabelaAtual.addRow(new Object[]{tarefa.getNome(), tarefa.getDescricao(), dataVencimentoStr});

                boolean inseridaComSucesso = tarefaDAO.inserirTarefa(tarefa);
                if (inseridaComSucesso) {
                    System.out.println("Tarefa inserida no banco de dados com sucesso!");
                } else {
                    System.out.println("Falha ao inserir a tarefa no banco de dados.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Falha ao formatar a data.");
            }
        }
    }

    // Método para inserir tarefa no banco de dados
    private void inserirTarefaNoBancoDeDados(String nome, String descricao, String dataVencimento) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO tarefas (nome, descricao, data_vencimento) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, descricao);
            statement.setString(3, dataVencimento);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir tarefa do banco de dados
    private void excluirTarefaDoBancoDeDados(Tarefa tarefa) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM tarefas WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tarefa.getNome());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Não inicie o sistema de tarefas aqui
            // new GerenciadorTarefasTrelloGUI()
            Login loginFrame = new Login();
            loginFrame.setVisible(true);
        });
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

package gestaodetarefas;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciadorTarefasComLoginGUI {

    private JFrame frame;
    private JTextField nomeTarefaField;
    private JTextField descricaoTarefaField;
    private JTextField dataVencimentoField;
    private DefaultTableModel tarefaTableModel;
    private JTable tarefaTable;
    private List<Tarefa> tarefas;

    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private boolean loggedIn = false;

    public GerenciadorTarefasComLoginGUI() {
        frame = new JFrame("Gerenciador de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tarefas = new ArrayList<>();
        tarefaTableModel = new DefaultTableModel(new String[]{"Nome", "Descrição", "Data de Vencimento"}, 0);
        tarefaTable = new JTable(tarefaTableModel);
        tarefaTable.setRowHeight(40);
        tarefaTable.getTableHeader().setReorderingAllowed(false);

        if (!loggedIn) {
            criarTelaDeLogin();
        } else {
            criarInterfacePrincipal();
        }

        frame.setVisible(true);
    }

    private void criarInterfacePrincipal() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel entradaPainel = new JPanel(new GridLayout(4, 2));
        JLabel nomeTarefaLabel = new JLabel("Nome da Tarefa:");
        nomeTarefaField = new JTextField();
        JLabel descricaoTarefaLabel = new JLabel("Descrição da Tarefa:");
        descricaoTarefaField = new JTextField();
        JLabel dataVencimentoLabel = new JLabel("Data de Vencimento (dd/MM/yyyy):");
        dataVencimentoField = new JTextField();
        JButton adicionarTarefaButton = new JButton("Adicionar Tarefa");
        adicionarTarefaButton.setBackground(Color.GREEN);
        adicionarTarefaButton.setForeground(Color.WHITE);
        adicionarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });
        entradaPainel.add(nomeTarefaLabel);
        entradaPainel.add(nomeTarefaField);
        entradaPainel.add(descricaoTarefaLabel);
        entradaPainel.add(descricaoTarefaField);
        entradaPainel.add(dataVencimentoLabel);
        entradaPainel.add(dataVencimentoField);
        entradaPainel.add(adicionarTarefaButton);

        JPanel acoesPainel = new JPanel();
        JButton excluirTarefaButton = new JButton("Excluir Tarefa");
        excluirTarefaButton.setBackground(Color.RED);
        excluirTarefaButton.setForeground(Color.WHITE);
        excluirTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirTarefa();
            }
        });
        JButton atualizarTarefaButton = new JButton("Atualizar Tarefa");
        atualizarTarefaButton.setBackground(Color.BLUE);
        atualizarTarefaButton.setForeground(Color.WHITE);
        atualizarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTarefa();
            }
        });
        acoesPainel.add(excluirTarefaButton);
        acoesPainel.add(atualizarTarefaButton);

        painel.add(entradaPainel, BorderLayout.NORTH);
        painel.add(new JScrollPane(tarefaTable), BorderLayout.CENTER);
        painel.add(acoesPainel, BorderLayout.SOUTH);

        frame.add(painel);
        frame.revalidate();
        frame.repaint();
    }

    private void criarTelaDeLogin() {
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(0, 102, 204));

        JLabel titleLabel = new JLabel("Bem-vindo ao Gerenciador de Tarefas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 153, 51));
        loginButton.setForeground(Color.WHITE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerLogin();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0);

        loginPanel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 10);
        loginPanel.add(new JLabel("Nome de Usuário:"), gbc);

        gbc.gridx++;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Senha:"), gbc);

        gbc.gridx++;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        frame.add(loginPanel);
        frame.revalidate();
        frame.repaint();
    }

    private void fazerLogin() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String storedUsername = "user"; // Nome de usuário de exemplo
        char[] storedPassword = "password".toCharArray(); // Senha de exemplo

        if (username.equals(storedUsername) && java.util.Arrays.equals(password, storedPassword)) {
            loggedIn = true;
            usernameField.setText("");
            passwordField.setText("");
            frame.getContentPane().remove(loginPanel);
            frame.revalidate();
            frame.repaint();
            criarInterfacePrincipal();
        } else {
            JOptionPane.showMessageDialog(frame, "Login falhou. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarTarefa() {
        String nome = nomeTarefaField.getText();
        String descricao = descricaoTarefaField.getText();
        String dataVencimentoStr = dataVencimentoField.getText();

        if (!nome.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataVencimento = null;

            try {
                dataVencimento = dateFormat.parse(dataVencimentoStr);
            } catch (Exception ex) {
                // Tratamento de erro caso a data seja inválida
            }

            Tarefa tarefa = new Tarefa(nome, descricao, dataVencimento);
            tarefas.add(tarefa);
            tarefaTableModel.addRow(new Object[]{tarefa.getNome(), tarefa.getDescricao(), dateFormat.format(dataVencimento)});
            nomeTarefaField.setText("");
            descricaoTarefaField.setText("");
            dataVencimentoField.setText("");
        }
    }

    private void excluirTarefa() {
        int selectedRow = tarefaTable.getSelectedRow();
        if (selectedRow != -1) {
            tarefas.remove(selectedRow);
            tarefaTableModel.removeRow(selectedRow);
        }
    }

    private void atualizarTarefa() {
        int selectedRow = tarefaTable.getSelectedRow();
        if (selectedRow != -1) {
            String nome = nomeTarefaField.getText();
            String descricao = descricaoTarefaField.getText();
            String dataVencimentoStr = dataVencimentoField.getText();

            if (!nome.isEmpty()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dataVencimento = null;

                try {
                    dataVencimento = dateFormat.parse(dataVencimentoStr);
                } catch (Exception ex) {
                    // Tratamento de erro caso a data seja inválida
                }

                Tarefa tarefa = tarefas.get(selectedRow);
                tarefa.setNome(nome);
                tarefa.setDescricao(descricao);
                tarefa.setDataVencimento(dataVencimento);

                tarefaTableModel.setValueAt(tarefa.getNome(), selectedRow, 0);
                tarefaTableModel.setValueAt(tarefa.getDescricao(), selectedRow, 1);
                tarefaTableModel.setValueAt(dateFormat.format(dataVencimento), selectedRow, 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GerenciadorTarefasComLoginGUI());
    }
}

class Tarefa {

    private String nome;
    private String descricao;
    private Date dataVencimento;

    public Tarefa(String nome, String descricao, Date dataVencimento) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}

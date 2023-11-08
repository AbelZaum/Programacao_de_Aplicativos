import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorTarefasComLoginGUI {

    private JFrame frame;
    private JTextField nomeTarefaField;
    private JTextField descricaoTarefaField;
    private JTextField dataVencimentoField;
    private DefaultTableModel tarefaTableModel;
    private JTable tarefaTable;
    private List<Tarefa> tarefas;

    private JComboBox<String> estadoComboBox;  // JComboBox para selecionar o estado
    private JButton adicionarTarefaButton;  // Botão para adicionar tarefas
    private boolean loggedIn = true;  // Defina como true para evitar a tela de login

    public GerenciadorTarefasComLoginGUI() {
        frame = new JFrame("Gerenciador de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tarefas = new ArrayList<>();
        tarefaTableModel = new DefaultTableModel(new String[]{"Nome", "Descrição", "Data de Vencimento", "Estado"}, 0);
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

        estadoComboBox = new JComboBox<>(new String[]{"A fazer", "Em andamento", "Concluídas"});

        adicionarTarefaButton = new JButton("Adicionar Tarefa");
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
        entradaPainel.add(new JLabel("Estado:"));
        entradaPainel.add(estadoComboBox);

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

        painel.add(entradaPainel, BorderLayout.NORTH);
        painel.add(new JScrollPane(tarefaTable), BorderLayout.CENTER);
        acoesPainel.add(excluirTarefaButton);
        acoesPainel.add(atualizarTarefaButton);
        acoesPainel.add(adicionarTarefaButton);  // Adicione o botão de adicionar tarefa
        painel.add(acoesPainel, BorderLayout.SOUTH);

        frame.add(painel);
        frame.revalidate();
        frame.repaint();
    }

    private void criarTelaDeLogin() {
        // Simulação de login, você pode implementar seu próprio método de autenticação aqui.
        loggedIn = true;
    }

    private void adicionarTarefa() {
        String nome = nomeTarefaField.getText();
        String descricao = descricaoTarefaField.getText();
        String dataVencimentoStr = dataVencimentoField.getText();
        String estado = (String) estadoComboBox.getSelectedItem();

        if (!nome.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataVencimento = null;

            try {
                dataVencimento = dateFormat.parse(dataVencimentoStr);
            } catch (Exception ex) {
                // Tratamento de erro caso a data seja inválida
            }

            Tarefa tarefa = new Tarefa(nome, descricao, dataVencimento, estado);
            tarefas.add(tarefa);
            tarefaTableModel.addRow(new Object[]{tarefa.getNome(), tarefa.getDescricao(), dateFormat.format(dataVencimento), tarefa.getEstado()});
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
            String estado = (String) estadoComboBox.getSelectedItem();

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
                tarefa.setEstado(estado);

                tarefaTableModel.setValueAt(tarefa.getNome(), selectedRow, 0);
                tarefaTableModel.setValueAt(tarefa.getDescricao(), selectedRow, 1);
                tarefaTableModel.setValueAt(dateFormat.format(dataVencimento), selectedRow, 2);
                tarefaTableModel.setValueAt(estado, selectedRow, 3);
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
    private String estado;

    public Tarefa(String nome, String descricao, Date dataVencimento, String estado) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

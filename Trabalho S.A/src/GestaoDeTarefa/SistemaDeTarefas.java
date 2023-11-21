package GestaoDeTarefa;

import DAO.TarefaDAO;
import Entity.Tarefa;
import javax.swing.JTable;
import java.util.Arrays;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class SistemaDeTarefas extends javax.swing.JFrame {

    // Adicione as informações do seu banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/taskers_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private TarefaDAO tarefaDAO;
    private Connection conexao;
    private String status;

    public SistemaDeTarefas() {
        initComponents();
        SetIconImage();
        conectarAoBanco();

    }

    private void conectarAoBanco() {
        try {
            // Registre o driver JDBC
            DriverManager.registerDriver(new Driver());

            // Estabeleça a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private void preencherTabela(JTable tabela, List<Tarefa> tarefas) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        for (Tarefa tarefa : tarefas) {
            Object[] rowData = {tarefa.getNome(), tarefa.getDescricao(), tarefa.getDataVencimento()};
            model.addRow(rowData);
        }
    }

    private void limparTabelas() {
        DefaultTableModel modelAFAZER = (DefaultTableModel) tabelaAFAZER.getModel();
        DefaultTableModel modelANDAMENTO = (DefaultTableModel) tabelaANDAMENTO.getModel();
        DefaultTableModel modelCONCLUIDO = (DefaultTableModel) tabelaCONCLUIDO.getModel();

        modelAFAZER.setRowCount(0);
        modelANDAMENTO.setRowCount(0);
        modelCONCLUIDO.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabelaAFAZER = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabelaCONCLUIDO = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabelaANDAMENTO = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DescriçãoTarefa = new javax.swing.JTextField();
        dataVencimentoTarefa = new javax.swing.JFormattedTextField();
        nomeTarefa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Taskers");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.orange);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));
        jPanel2.setMaximumSize(new java.awt.Dimension(1200, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(1200, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 600));

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setLabelFor(jScrollPane10);
        jLabel6.setText("CONCLUIDO");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabelaAFAZER.setBackground(new java.awt.Color(51, 51, 51));
        tabelaAFAZER.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        tabelaAFAZER.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabelaAFAZER.setForeground(new java.awt.Color(255, 255, 255));
        tabelaAFAZER.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TAREFAS", "DESCRIÇÃO", "VENCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAFAZER.setGridColor(new java.awt.Color(51, 51, 51));
        tabelaAFAZER.setMinimumSize(new java.awt.Dimension(45, 600));
        tabelaAFAZER.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tabelaAFAZER.setSelectionForeground(new java.awt.Color(255, 102, 0));
        tabelaAFAZER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAFAZERMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tabelaAFAZER);

        tabelaCONCLUIDO.setBackground(new java.awt.Color(51, 51, 51));
        tabelaCONCLUIDO.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelaCONCLUIDO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabelaCONCLUIDO.setForeground(new java.awt.Color(255, 255, 255));
        tabelaCONCLUIDO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TAREFAS", "DESCRIÇÃO", "VENCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCONCLUIDO.setMinimumSize(new java.awt.Dimension(45, 600));
        tabelaCONCLUIDO.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tabelaCONCLUIDO.setSelectionForeground(new java.awt.Color(255, 102, 0));
        tabelaCONCLUIDO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCONCLUIDOMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabelaCONCLUIDO);

        tabelaANDAMENTO.setBackground(new java.awt.Color(51, 51, 51));
        tabelaANDAMENTO.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelaANDAMENTO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabelaANDAMENTO.setForeground(new java.awt.Color(255, 255, 255));
        tabelaANDAMENTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TAREFAS", "DESCRIÇÃO", "VENCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaANDAMENTO.setMinimumSize(new java.awt.Dimension(45, 600));
        tabelaANDAMENTO.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tabelaANDAMENTO.setSelectionForeground(new java.awt.Color(255, 102, 0));
        tabelaANDAMENTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaANDAMENTOMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tabelaANDAMENTO);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoIcon (2).png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel7.setMinimumSize(new java.awt.Dimension(40, 90));
        jLabel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel7ComponentHidden(evt);
            }
        });
        jLabel7.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jLabel7VetoableChange(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 102, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setLabelFor(jScrollPane10);
        jLabel9.setText("ANDAMENTO");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel10.setBackground(new java.awt.Color(255, 102, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setLabelFor(jScrollPane10);
        jLabel10.setText("A FAZER");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DescriçãoTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriçãoTarefaActionPerformed(evt);
            }
        });

        dataVencimentoTarefa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yy"))));

        nomeTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTarefaActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 102, 0));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 0));
        jLabel11.setLabelFor(jScrollPane10);
        jLabel11.setText("Taskers");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Nome da Tarefa");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Descrição da Tarefa");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Data de Vencimento");

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Excluir");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Nome da Tarefa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nomeTarefa, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DescriçãoTarefa)
                        .addComponent(dataVencimentoTarefa)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DescriçãoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataVencimentoTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jLabel7VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7VetoableChange

    private void jLabel7ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel7ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7ComponentHidden

    private void DescriçãoTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriçãoTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriçãoTarefaActionPerformed

    private void nomeTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTarefaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nome = nomeTarefa.getText();
        String descricao = DescriçãoTarefa.getText();
        String dataVencimento = dataVencimentoTarefa.getText();

        DefaultTableModel model1 = (DefaultTableModel) tabelaAFAZER.getModel();

        Object[] rowData = {nome, descricao, dataVencimento};
        model1.addRow(rowData);
        jComboBox1.addItem(nome);

        nomeTarefa.setText("");
        DescriçãoTarefa.setText("");
        dataVencimentoTarefa.setText("");

        inserirTarefaNoBanco(nome, descricao, dataVencimento);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inserirTarefaNoBanco(String nome, String descricao, String dataVencimento) {
        // Tratamento da data de vencimento
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVencimentoDate;

        try {
            // Tenta fazer o parsing da data fornecida
            dataVencimentoDate = dateFormat.parse(dataVencimento);
        } catch (ParseException e) {
            // Se ocorrer uma exceção, a data fornecida é inválida
            JOptionPane.showMessageDialog(null,"Erro: Data de vencimento inválida. Certifique-se de usar o formato dd/MM/yyyy.");
            return; // ou você pode lançar uma exceção ou tomar outra ação apropriada
        }

        try {
            // Use PreparedStatement para evitar SQL Injection
            String sql = "INSERT INTO tarefas (nome, descricao, data_vencimento, status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setString(1, nome);
                pstmt.setString(2, descricao);
                pstmt.setString(3, dataVencimento);
                pstmt.setString(4, "A FAZER"); // Status inicial é "A FAZER"
                pstmt.executeUpdate();
            }

            System.out.println("Tarefa inserida no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir tarefa no banco de dados: " + e.getMessage());
        }

    }

    private void tabelaAFAZERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAFAZERMouseClicked
        DefaultTableModel model1 = (DefaultTableModel) tabelaAFAZER.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tabelaANDAMENTO.getModel();

        int row = tabelaAFAZER.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            Object[] rowData = new Object[]{model1.getValueAt(row, 0), model1.getValueAt(row, 1), model1.getValueAt(row, 2), "ANDAMENTO"};
            model1.removeRow(row);
            model2.addRow(rowData);

            // Atualize o status no banco de dados
            atualizarStatusTarefa((String) rowData[0], "ANDAMENTO");
        }
    }//GEN-LAST:event_tabelaAFAZERMouseClicked

    private void atualizarStatusTarefa(String nomeTarefa, String novoStatus) {
        try {
            String sql = "UPDATE tarefas SET status = ? WHERE nome = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setString(1, novoStatus);
                pstmt.setString(2, nomeTarefa);
                pstmt.executeUpdate();
            }

            System.out.println("Status da tarefa atualizado no banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status da tarefa no banco de dados: " + e.getMessage());
        }
    }


    private void tabelaANDAMENTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaANDAMENTOMouseClicked
        DefaultTableModel model2 = (DefaultTableModel) tabelaANDAMENTO.getModel();
        DefaultTableModel model3 = (DefaultTableModel) tabelaCONCLUIDO.getModel();

        int row = tabelaANDAMENTO.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            Object[] rowData = new Object[]{model2.getValueAt(row, 0), model2.getValueAt(row, 1), model2.getValueAt(row, 2)};
            model2.removeRow(row);
            model3.addRow(rowData);
        }
    }//GEN-LAST:event_tabelaANDAMENTOMouseClicked

    private void tabelaCONCLUIDOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCONCLUIDOMouseClicked
        DefaultTableModel model3 = (DefaultTableModel) tabelaCONCLUIDO.getModel();
        DefaultTableModel model1 = (DefaultTableModel) tabelaAFAZER.getModel();

        int row = tabelaCONCLUIDO.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            Object[] rowData = new Object[]{model3.getValueAt(row, 0), model3.getValueAt(row, 1), model3.getValueAt(row, 2)};
            model3.removeRow(row);
            model1.addRow(rowData);
        }
    }//GEN-LAST:event_tabelaCONCLUIDOMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nomeSelecionado = (String) jComboBox1.getSelectedItem();

        // Remova a tarefa da tabela
        List<JTable> tabelas = Arrays.asList(tabelaAFAZER, tabelaANDAMENTO, tabelaCONCLUIDO);
        for (JTable tabela : tabelas) {
            DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
            for (int i = 0; i < modeloTabela.getRowCount(); i++) {
                String nomeLinha = modeloTabela.getValueAt(i, 0).toString();
                if (nomeLinha.equals(nomeSelecionado)) {
                    modeloTabela.removeRow(i);
                    break;
                }
            }
        }

        // Remova a tarefa do banco de dados
        excluirTarefaDoBanco(nomeSelecionado);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void excluirTarefaDoBanco(String nomeTarefa) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskers_db", "root", "");
            String sql = "DELETE FROM tarefas WHERE nome = ?";
            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setString(1, nomeTarefa);
                preparedStatement.executeUpdate();
            }
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção conforme necessário
        }
    }


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed


    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaDeTarefas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SistemaDeTarefas().setVisible(true);
        });
    }

    private void SetIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LogoIcon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DescriçãoTarefa;
    private javax.swing.JFormattedTextField dataVencimentoTarefa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JTextField nomeTarefa;
    private javax.swing.JTable tabelaAFAZER;
    private javax.swing.JTable tabelaANDAMENTO;
    private javax.swing.JTable tabelaCONCLUIDO;
    // End of variables declaration//GEN-END:variables

}

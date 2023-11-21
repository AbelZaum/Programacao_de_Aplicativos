package DAO;

import Conexao.ModuloConexao;
import Entity.Clientes;
import Entity.Tarefa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    private Connection conexao;
    private Clientes usuarioLogado;

    public void setUsuarioLogado(Clientes usuario) {
        this.usuarioLogado = usuario;
    }

    public void carregarTarefasPorStatus(String status) {
        if (this.usuarioLogado != null) {
            int idUsuario = this.usuarioLogado.getId();
            // Restante do código
        } else {
            System.out.println("Usuário não está logado.");
        }
    }

    public List<Tarefa> carregarTarefasPorStatus(Clientes cliente, String status) {
        List<Tarefa> tarefas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tarefas WHERE id_usuario = ? AND status = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setInt(1, usuarioLogado.getId());  // Substitua pelo método correto que retorna o ID do usuário
                pstmt.setString(2, status);
                ResultSet resultado = pstmt.executeQuery();

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String descricao = rs.getString("descricao");
                        String dataVencimento = rs.getString("data_vencimento");

                        Tarefa tarefa = new Tarefa(id, nome, descricao, dataVencimento, status);
                        tarefas.add(tarefa);
                    }
                }
            }

            System.out.println("Tarefas carregadas por status.");
        } catch (SQLException e) {
            System.err.println("Erro ao carregar tarefas por status: " + e.getMessage());
        }

        return tarefas;
    }

    public void salvarTarefa(Tarefa tarefa, Clientes cliente) {
        String sql = "INSERT INTO tarefas (id_usuario, nome, descricao, data_vencimento, status) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, tarefa.getNome());
            stmt.setString(3, tarefa.getDescricao());
            stmt.setDate(4, new java.sql.Date(tarefa.getDataVencimento().getTime()));
            stmt.setString(5, tarefa.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Exemplo de método para adicionar uma tarefa
    public static void adicionarTarefa(Tarefa tarefa, Clientes usuario) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ModuloConexao.conector();
            String sql = "INSERT INTO tarefas (nome, descricao, data_vencimento, id_usuario, status) VALUES (?, ?, ?, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tarefa.getNome());
            stmt.setString(2, tarefa.getDescricao());

            // Convertendo java.util.Date para java.sql.Date
            java.util.Date utilDate = tarefa.getDataVencimento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(3, sqlDate);

            stmt.setString(4, tarefa.getStatus());
            // Restante do seu código

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    // Implemente métodos semelhantes para remover, atualizar tarefas, etc.
    // Exemplo de método para remover uma tarefa
    public static void removerTarefa(int idTarefa) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ModuloConexao.conector();
            String sql = "DELETE FROM tarefas WHERE id = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTarefa);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}

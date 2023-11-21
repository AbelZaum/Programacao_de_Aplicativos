package DAO;

import Conexao.ModuloConexao;
import Entity.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UsuarioDAO {

    public void cadastrarUsuario(Clientes usuario) {
        Connection conexao = null;
        PreparedStatement pst = null;

        try {
            conexao = ModuloConexao.conector();
            String sql = "INSERT INTO usuarios (nome_usuario, senha) VALUES (?, ?)";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            pst.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        } finally {
            // Feche os recursos adequadamente, por exemplo:
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }
    }

    public boolean verificarLogin(String usuario, String senha) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ModuloConexao.conector();

            // Consulta SQL para verificar o login
            String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            // Se houver resultados, o login é válido
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ModuloConexao.closeConnection(conexao, stmt, rs);
        }
    }

}

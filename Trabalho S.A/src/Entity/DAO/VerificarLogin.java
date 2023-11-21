package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarLogin {
    
    public static boolean verificarUsuario(String userLoginString, String senhaLoginString) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Estabeleça a conexão com o banco de dados (substitua as informações de conexão conforme necessário)
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaodetarefas", "root", "");

            // Crie a consulta SQL para verificar o usuário
            String sql = "SELECT * FROM CLIENTES WHERE LOGIN = ? AND SENHA = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, userLoginString);
            pst.setString(2, senhaLoginString);

            // Execute a consulta
            rs = pst.executeQuery();

            // Verifique se o usuário existe e se a senha corresponde
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Feche os recursos
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Em caso de erro, retorne false
        return false; 
    }
}

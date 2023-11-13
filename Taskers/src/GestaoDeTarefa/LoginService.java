package GestaoDeTarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    public static boolean autenticarUsuario(String nomeUsuario, String senha) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, nomeUsuario);
            statement.setString(2, senha);
            resultSet = statement.executeQuery();

            return resultSet.next(); // Retorna true se as credenciais estiverem corretas
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           
        }

        return false; // Retorna false se ocorrer um erro ou as credenciais estiverem erradas
    }
}

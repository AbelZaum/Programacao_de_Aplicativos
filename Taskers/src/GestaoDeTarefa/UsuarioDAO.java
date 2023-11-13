package GestaoDeTarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public UsuarioDAO() {
        // Construtor da classe
    }

    public boolean cadastrarUsuario(String nomeUsuario, String senha) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();

            // Verifica se o nome de usuário já existe
            String checkUserQuery = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
            PreparedStatement checkUserStatement = connection.prepareStatement(checkUserQuery);
            checkUserStatement.setString(1, nomeUsuario);
            ResultSet resultSet = checkUserStatement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);

            if (count > 0) {
                // Nome de usuário já existe, retornar falso
                return false;
            } else {
                // Nome de usuário não existe, prosseguir com o cadastro
                String insertQuery = "INSERT INTO usuarios (nome_usuario, senha) VALUES (?, ?)";
                statement = connection.prepareStatement(insertQuery);
                statement.setString(1, nomeUsuario);
                statement.setString(2, senha);

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
}

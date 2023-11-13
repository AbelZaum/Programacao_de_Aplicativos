package GestaoDeTarefa;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroService {

    private boolean cadastrarUsuario(String nomeUsuario, String senha) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO usuarios (nome_usuario, senha) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeUsuario);
            statement.setString(2, senha);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}

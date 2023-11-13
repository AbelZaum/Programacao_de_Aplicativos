package GestaoDeTarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TarefaDAO {

    public boolean inserirTarefa(Tarefa tarefa) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO tarefas (nome, descricao, data_vencimento, id_usuario) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tarefa.getNome());
            statement.setString(2, tarefa.getDescricao());

            // Converta a data para um formato compatível com o banco de dados
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataVencimentoFormatted = dateFormat.format(tarefa.getDataVencimento());

            statement.setString(3, dataVencimentoFormatted); 
            statement.setInt(4, tarefa.getIdUsuario());

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

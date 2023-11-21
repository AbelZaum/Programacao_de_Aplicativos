
package GestaoDeTarefa;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import DAO.UsuarioDAO;
import Entity.Clientes;

public class testSQL {
    
    public static void main(String[] args) {
        
        Clientes u = new Clientes();
        u.setLogin("joaoGamer");
        u.setSenha("joao123");
        
        new UsuarioDAO().cadastrarUsuario(u);
    }
}

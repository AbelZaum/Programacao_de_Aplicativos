package GestaoDeTarefa;

import java.util.ArrayList;
import java.util.List;

public class CadastroService {

    private List<Usuario> usuariosRegistrados;

    public CadastroService() {
        usuariosRegistrados = new ArrayList<>();
    }

    public boolean cadastrarUsuario(String nomeUsuario, String senha) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return false; // Nome de usuário já existe
            }
        }

        Usuario novoUsuario = new Usuario(nomeUsuario, senha);
        usuariosRegistrados.add(novoUsuario);
        return true;
    }

    public boolean verificarCredenciais(String nomeUsuario, String senha) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                return true; // Credenciais corretas
            }
        }
        return false; // Credenciais incorretas
    }
}

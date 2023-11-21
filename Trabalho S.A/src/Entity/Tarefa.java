package Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarefa {

    private int id;
    private String nome;
    private String descricao;
    private Date dataVencimento;
    private String status;
    private int idUsuario;

    // Construtores, getters e setters
    // Exemplo de construtor
    public Tarefa(int id, String nome, String descricao, String dataVencimentoStr, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;

        // Converte a string de data para o objeto Date
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            this.dataVencimento = dateFormat.parse(dataVencimentoStr);
        } catch (ParseException e) {
            System.err.println("Erro ao converter a data: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Tarefa{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", descricao='" + descricao + '\''
                + ", dataVencimento=" + dataVencimento
                + ", status='" + status + '\''
                + '}';
    }

    // Métodos getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

}

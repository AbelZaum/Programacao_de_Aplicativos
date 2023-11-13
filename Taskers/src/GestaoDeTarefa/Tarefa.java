package GestaoDeTarefa;

import java.util.Date; // Importe a classe Date

public class Tarefa {

    private String nome;
    private String descricao;
    private Date dataVencimento; 
    private String status;
    private int idUsuario;

    public Tarefa(String nome, String descricao, Date dataVencimento) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.status = "A fazer";
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

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

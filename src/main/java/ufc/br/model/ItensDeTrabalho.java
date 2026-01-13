package ufc.br.model;

public class ItensDeTrabalho {
    private String titulo;
    private String descricao;
    private String responsavel;
    private Status status;

    public ItensDeTrabalho() {

    }
    public ItensDeTrabalho(String titulo, String descricao, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

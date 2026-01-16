package ufc.br.model;

public class ItensDeTrabalho {
    private String titulo;
    private String descricao;
    private String responsavel;
    private boolean finalizado;
    public ItensDeTrabalho() {

    }
    public ItensDeTrabalho(String titulo, String descricao, String responsavel) {
        setTitulo(titulo);
        setDescricao(descricao);
        setResponsavel(responsavel);
        this.finalizado = false;
    }

    public void atualizarStatus(){
        finalizado =!finalizado;
    }

    public boolean isFinalizado() {

        return finalizado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo!=null) {
            this.titulo = titulo;
        }
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

}

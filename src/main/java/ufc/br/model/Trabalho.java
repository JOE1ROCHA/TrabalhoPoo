package ufc.br.model;
import ufc.br.view.NewTrabalhoView;
import ufc.br.model.Usuario;
import java.util.List;

public class Trabalho {
    private String descricao;
    private String titulo;
    private Usuario autor;
    private Usuario responsavel;
    private List<ItensDeTrabalho> listaItensDeTrabalho;
    private Status status;

    public Trabalho() {
    }

    public Trabalho(String descricao, Usuario autor, Usuario responsavel) {
        this.descricao = descricao;
        this.autor = autor;
        this.responsavel = responsavel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public List<ItensDeTrabalho> getListaItensDeTrabalho() {
        return listaItensDeTrabalho;
    }

    public void setListaItensDeTrabalho(List<ItensDeTrabalho> listaItensDeTrabalho) {
        this.listaItensDeTrabalho = listaItensDeTrabalho;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void handleEvent (String event){

    }

}

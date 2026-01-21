package ufc.br.model;

import ufc.br.view.NewTrabalhoView;
import ufc.br.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Trabalho {
    private String descricao;
    private String titulo;
    private String autor;
    private String responsavel;
    private List<ItensDeTrabalho> listaTarefas;

    public Trabalho() {
        this.listaTarefas = new ArrayList<>();
    }

    public Trabalho(String descricao, String autor, String responsavel, String titulo) {
        this.listaTarefas = new ArrayList<>();
        setDescricao(descricao);
        setAutor(autor);
        setResponsavel(responsavel);
        setTitulo(titulo);
    }

    public double porcentagemConluido() {
        if (listaTarefas == null || listaTarefas.isEmpty()) {
            return 0.0;
        }

        long concluidos = listaTarefas.stream()
                .filter(ItensDeTrabalho::isFinalizado)
                .count();

        return (double) concluidos / listaTarefas.size(); // 0.0 a 1.0
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

    public List<ItensDeTrabalho> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<ItensDeTrabalho> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor!=null) {
            this.autor = autor;
        }
    }

    public void handleEvent(String event) {

    }

    @Override
    public String toString() {
        return "======================================\n" +
                "titulo: " + titulo + "\n" +
                "descricao: " + descricao + "\n" +
                "autor: " + autor + "\n" +
                "responsavel: " + responsavel + "\n";
    }
}

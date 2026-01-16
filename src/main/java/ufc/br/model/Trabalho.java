package ufc.br.model;

import ufc.br.view.NewTrabalhoView;
import ufc.br.model.Usuario;

import java.util.List;

public class Trabalho {
    private String descricao;
    private String titulo;
    private String autor;
    private String responsavel;
    private List<ItensDeTrabalho> listaTarefas;
    private boolean status;

    public Trabalho() {
    }

    public Trabalho(String descricao, String autor, String responsavel, String titulo) {
        this.descricao = descricao;
        this.autor = autor;
        this.responsavel = responsavel;
        this.titulo = titulo;
    }

    public float porcentagemConluido() {
        if (listaTarefas == null||listaTarefas.isEmpty()) {
            return 0;
        }
        float quantConcluidos = 0;

        for (ItensDeTrabalho iten : listaTarefas) {
            if (iten.isFinalizado()) {
                quantConcluidos++;
            }
        }
        return (quantConcluidos / listaTarefas.size())*100;
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
        this.autor = autor;
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

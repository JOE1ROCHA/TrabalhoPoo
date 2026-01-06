package ufc.br.view;

import ufc.br.controller.NewTrabalhoController;
import ufc.br.model.Trabalho;
import ufc.br.model.Usuario;
import java.util.Scanner;

public class NewTrabalhoView {
    private NewTrabalhoController controller;
    private Usuario model;
    private String descricao;
    private String titulo;
    private Usuario autor;
    private Usuario responsavel;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public void init(Usuario model) {
        this.model = model;
        controller = new NewTrabalhoController();
        controller.init(model, this);
        model.addTrabalho(this);
        cadastrarTrabalho();
    }

    public void cadastrarTrabalho() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TELA CADASTRAR TRABALHO");
        System.out.println("======================");
        System.out.println();
        System.out.print("Titulo: ");
        titulo = sc.nextLine();
        System.out.print("Descricao: ");
        descricao = sc.nextLine();
        System.out.print("Autor: ");
        autor = model.getAutor();
        System.out.print("Responsavel: ");
        responsavel = model.getResponsavel();
        controller.handleEvent("OK");
        model.addTrabalho(this);
    }


}

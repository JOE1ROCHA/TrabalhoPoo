package ufc.br.view;

import ufc.br.controller.NewTrabalhoController;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.model.Usuario;
import java.util.Scanner;

public class NewTrabalhoView implements Observer {
    private NewTrabalhoController controller;
    private Model model;
    private String descricao;
    private String titulo;
    private String autor;
    private String responsavel;


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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void init(Model model) {
        if(model!= null) {
            this.model = model;
            controller = new NewTrabalhoController();
            //controller.init(model, this);
            model.attachObserver(this);
            cadastrarTrabalho();
        }
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
        autor = sc.nextLine();
        System.out.print("Responsavel: ");
        responsavel = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public void update() {

    }

}

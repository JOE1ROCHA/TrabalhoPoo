package ufc.br.view;

import ufc.br.controller.NewTarefaController;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.model.Status;

import java.util.Scanner;

public class NewTarefaView implements Observer {
    private NewTarefaController controller;
    private Model model;
    private String titulo;
    private String descricao;
    private String responsavel;
    private boolean status = false;

    public NewTarefaView() {

    }

    public NewTarefaView(String titulo, String descricao, String responsavel) {
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

    public void init(Model model) {
        if(model!= null) {
            this.model = model;
            controller = new NewTarefaController();
            controller.init(model, this);
            model.attachObserver(this);
            cadastrarTarefa();
        }
    }

    public void cadastrarTarefa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TELA CADASTRAR TAREFA");
        System.out.println("======================");
        System.out.println();
        System.out.print("Titulo: ");
        titulo = sc.nextLine();
        System.out.print("Descricao: ");
        descricao = sc.nextLine();
        System.out.print("Responsavel: ");
        responsavel = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public void update() {

    }
}

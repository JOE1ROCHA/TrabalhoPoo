package ufc.br.view;

import ufc.br.controller.TarefasController;
import ufc.br.model.ItensDeTrabalho;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.model.Trabalho;

import java.util.List;
import java.util.Scanner;

public class TarefasView implements Observer {
    private Model model;
    private TarefasController controller;
    private String usuarioLogado;
    private int totalUsers;

    public void init(Model model) {
        if (model != null) {
            this.model = model;    // Guarda o modelo
            controller = new TarefasController();    // Cria seu controller
            controller.init(model, this);    // Inicializa o controller
            model.attachObserver(this);    // Registra a view na lista de observadores do modelo
            listarTarefas();    // Chama o menu principal
        }
    }

    // lista os trabalhos cadastrados do usuario logado
    public void listarTarefas() {
        ;
        String tituloTrabalho = model.getTrabalhoSelecionado().getTitulo();
        System.out.println("LISTA DE TAREFAS");
        System.out.println();
        List<ItensDeTrabalho> listaTarefas = model.getListaTarefas(tituloTrabalho);

        if(listaTarefas == null){
            System.out.println("Lista vazia, faca o cadastro\n");
            NewTarefaView itensTrabalhos = new NewTarefaView();
            itensTrabalhos.init(model);
        }
        else {
            int i = 0;
            for (ItensDeTrabalho iten : listaTarefas) {
                System.out.println(++i + " - " + iten.getTitulo());
            }

            System.out.print("-1 Voltar\n");
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o numero da opcao desejada: ");
            int opc = sc.nextInt();

            if (opc == -1) {
                TrabalhosView trabalhoView = new TrabalhosView();
                trabalhoView.init(model);
            }

            ItensDeTrabalho iten = listaTarefas.get(opc - 1);
            System.out.println("Descricao: "+iten.getDescricao()+"\nResponsavel: "+iten.getResponsavel());
            menuPrincipalTarefas();
        }
    }

    public void menuPrincipalTarefas() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Voltar", "[2] - Excluir tarefa"};

        System.out.println();
        System.out.println(opcoes[0]);
        System.out.println(opcoes[1]);
        System.out.println();
        System.out.print("Digite a opcao desejada: ");
        String event = sc.nextLine();

        controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller
    }

    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
    }
}

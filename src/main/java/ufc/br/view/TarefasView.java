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

        if(listaTarefas==null){
            Scanner sc = new Scanner(System.in);
            System.out.println("AINDA NÃO HÁ TAREFAS CADASTRADAS NESSE TRABALHO !!\n\n");
            System.out.println("Deseja fazer o cadastro de uma nova tarefa?\n\n [1] - Sim \t\t [2] - nao\n");
            System.out.print("Digite a opcao desejada: ");
            String opc = sc.nextLine();

            if(opc.equals("1")){
                NewTarefaView cadastroTarefa = new NewTarefaView();
                cadastroTarefa.init(model);
            }
            else {
                TrabalhosView listaTrabalhos = new TrabalhosView();
                listaTrabalhos.init(model);
            }
        }
        else {
            int i = 0;
            for (ItensDeTrabalho iten : listaTarefas) {
                System.out.println(++i + " - " + iten.getTitulo()+" "+iten.isFinalizado());
            }

            System.out.print("\n[-1] - Voltar\t[-2] - Cadastrar Tarefa\n");
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o numero da opcao desejada: ");
            int opc = sc.nextInt();

            if (opc == -1) {
                TrabalhosView listaTrabalhos = new TrabalhosView();
                listaTrabalhos.init(model);
                return;
            }
            else if(opc==-2) {
                NewTarefaView cadastroTarefa = new NewTarefaView();
                cadastroTarefa.init(model);
            }else {
                model.setTarefaSelecionada(listaTarefas.get(opc - 1));

                ItensDeTrabalho iten = listaTarefas.get(opc - 1);
                System.out.println("Descricao: " + iten.getDescricao() + "\nResponsavel: " + iten.getResponsavel());
                menuPrincipalTarefas();
            }
        }
    }

    public void menuPrincipalTarefas() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Voltar", "[2] - Excluir tarefa","[3] - Finalizar"};

        System.out.println();
        System.out.println(opcoes[0]);
        System.out.println(opcoes[1]);
        System.out.println(opcoes[2]);
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

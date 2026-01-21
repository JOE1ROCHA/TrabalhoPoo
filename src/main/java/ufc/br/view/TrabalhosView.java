package ufc.br.view;

import ufc.br.controller.TrabalhosController;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.model.Trabalho;

import java.util.List;
import java.util.Scanner;

public class TrabalhosView implements Observer {
    private Model model;
    private TrabalhosController controller;
    private String usuarioLogado;
    private int totalUsers;

    public void init(Model model) {
        if (model != null) {
            this.model = model;    // Guarda o modelo
            controller = new TrabalhosController();    // Cria seu controller
            //controller.init(model, this);    // Inicializa o controller
            model.attachObserver(this);    // Registra a view na lista de observadores do modelo
            listarTrabalhos();    // Chama o menu principal
        }
    }

    // lista os trabalhos cadastrados do usuario logado
    public void listarTrabalhos() {

        String user = model.getUsuarioAutenticado();
        System.out.println("LISTA DE TRABALHOS");
        System.out.println();
        List<Trabalho> listaTrabalhos = model.getListaTrabalhos(user);
        if(listaTrabalhos== null){
            System.out.println("Lista vazia");
        }
        else {
            int i = 0;
            for (Trabalho trabalho : listaTrabalhos) {
                System.out.printf("%d - %s %.1f%% Concluido%n",++i,trabalho.getTitulo(),trabalho.porcentagemConluido());
            }

            System.out.print("\n[-1] - Voltar\n");
            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o numero da opcao desejada: ");
            int opc = sc.nextInt();
            ;

            if (opc == -1) {
                UserView userview = new UserView();
                userview.init(model);
                return;
            } if (opc < 1 || opc > listaTrabalhos.size()) {
                System.out.println("Opção inválida.");
                listarTrabalhos();
                return;
            }
            model.setTrabalhoSelecionado(listaTrabalhos.get(opc - 1));

            System.out.println(listaTrabalhos.get(opc - 1));
            menuPrincipalTrabalho();
        }
    }

    public void menuPrincipalTrabalho() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Voltar", "[2] - Ver minhas tarefas", "[3] - Excluir trabalho"};

        System.out.println();
        System.out.println(opcoes[0]);
        System.out.println(opcoes[1]);
        System.out.println(opcoes[2]);
        System.out.println();
        System.out.print("Digite a opcao desejada: ");
        String event = sc.nextLine();

       // controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller
    }

    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
    }
}

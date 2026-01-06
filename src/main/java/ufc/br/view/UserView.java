package ufc.br.view;

import ufc.br.controller.UserController;
import ufc.br.model.Model;
import ufc.br.model.Observer;

import java.util.Scanner;

public class UserView implements Observer {
    private Model model;
    private UserController controller;
    private boolean finalizar = false;
    private String usuarioLogado;
    private int totalUsers;

    public void finalizarSistema() {
        finalizar = true;
    }

    /*
     * Inicialização da view principal
     */
    public void init(Model model) {
        if (model != null) {
            this.model = model;    // Guarda o modelo
            controller = new UserController();    // Cria seu controller
            controller.init(model, this);    // Inicializa o controller
            model.attachObserver(this);    // Registra a view na lista de observadores do modelo
            menuPrincipalUser();    // Chama o menu principal
        }
    }

    /*
     * Menu de opções da tela principal
     */
    public void menuPrincipalUser() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Fazer Logout", "[2] - Ver meus trabalhos", "[3] - Cadastrar novo trabalho"};
        do {
            System.out.println("=============================");
            System.out.println("MENU DE USUARIO");
            System.out.println();

            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println();
            System.out.print("Digite a opcao desejada: ");
            String event = sc.nextLine();

            controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller

        } while (!finalizar);
        sc.close();
    }

    /*
     * Chamado quando acontece mudança no modelo e o notifica é acionado
     */
    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
    }
}

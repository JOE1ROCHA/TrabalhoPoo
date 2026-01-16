package ufc.br.view;

import ufc.br.controller.MainController;
import ufc.br.model.Model;
import ufc.br.model.Observer;

import java.util.Scanner;

public class MainView implements Observer {
    private Model model;    // Guarda o modelo a ser utilizado
    private MainController controller;    // Guarda o controller a ser utilizado
    private int totalUsers;    // Usado para armazenar o total de usuário que deve ser exibido na tela
    private String usuarioLogado; // Usado para armazenar o usuário logado no sistema
    private boolean finalizar = false;    // Flag para indicar quando a view será finalizada

    /*
     * Para finalizar a view principal, ou seja, encerrar o programa
     */
    public void finalizarSistema() {
        finalizar = true;
    }

    /*
     * Inicialização da view principal
     */
    public void init(Model model) {
        if (model != null) {
            this.model = model;    // Guarda o modelo
            controller = new MainController();    // Cria seu controller
            controller.init(model, this);    // Inicializa o controller
            model.attachObserver(this);    // Registra a view na lista de observadores do modelo
            menuPrincipal();    // Chama o menu principal
        }
    }

    /*
     * Menu de opções da tela principal
     */
    public void menuPrincipal() {
//        Scanner sc = new Scanner(System.in);
//        String opcoes[] = {"[1] - Fazer Login", "[2] - Fazer Cadastro", "[3] - Sair"};
//        do {
//            System.out.println("TELA INICIAL DO SISTEMA TESTE");
//            System.out.println("=============================");
//            System.out.println();
//            System.out.println("Total Usuarios: " + totalUsers);
//
//            System.out.println();
//            System.out.println(opcoes[0]);
//            System.out.println(opcoes[1]);
//            System.out.println(opcoes[2]);
//            System.out.println();
//            System.out.print("Digite a opcao desejada: ");
//            String event = sc.nextLine();
//            controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller
//        } while (!finalizar);
    }

    /*
     * Chamado quando acontece mudança no modelo e o notifica é acionado
     */
    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
    }
}

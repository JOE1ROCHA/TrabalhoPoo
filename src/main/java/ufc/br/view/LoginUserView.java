package ufc.br.view;

import ufc.br.controller.LoginUserController;
import ufc.br.model.Model;
import ufc.br.model.Observer;

import java.util.Scanner;

public class LoginUserView implements Observer {
    private Model model;
    private LoginUserController controller;
    private String login;
    private String senha;

    public void init(Model model) {
        this.model = model;
        controller = new LoginUserController();
        controller.init(model, this);
        model.attachObserver(this);
        logarUsuario();
    }

    public void logarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TELA DE LOGIN");
        System.out.println("======================");
        System.out.println();
        System.out.print("Login: ");
        login = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void update() {

    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
}
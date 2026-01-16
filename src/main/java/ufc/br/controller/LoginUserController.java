package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.ui.StageManager;
import ufc.br.view.LoginUserView;
import ufc.br.view.MainView;
import ufc.br.view.UserView;

public class LoginUserController {
    private Model model;
    private LoginUserView view;
    private Stage stage;

    // Inicializa controller com view e Stage compartilhado
    public void init(Model model, LoginUserView view, Stage stage) {
        if (model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
            model.attachObserver(view); // view continua observando
        }
    }

    // Manipula eventos da view
    public void handleEvent(String event) {
        switch (event) {
            case "OK":
                boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
                if (!autenticado) {
                    view.exibeMSG("ERRO: Usuário e/ou senha inválidos!");
                } else {
                    // Troca para UserView usando o mesmo Stage
                    UserView userView = new UserView();
                    userView.init(model, stage);
                }
                break;

            case "VOLTA":
                MainView mainview = new MainView();
                mainview.init(model, stage);
                break;
        }
    }
}

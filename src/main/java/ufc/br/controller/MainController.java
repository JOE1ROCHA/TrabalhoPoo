package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.LoginUserView;
import ufc.br.view.MainView;
import ufc.br.view.NewUserView;

public class MainController {
    private Model model;    // Modelo
    private MainView view;  // View principal
    private Stage stage;    // Stage principal para trocar telas

    // Inicializa controller com view e stage
    public void init(Model model, MainView view, Stage stage) {
        if (model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    // Manipula eventos da MainView
    public void handleEvent(String event) {
        switch (event) {
            case "1": // Login
                if (model.getUsuarioAutenticado().isEmpty()) {
                    LoginUserView loginView = new LoginUserView();
                    loginView.init(model, stage); // <-- passar Stage
                } else {
                    model.deslogarUsuario();
                }
                break;

            case "2": // Novo usuário
                NewUserView newUserView = new NewUserView();
                newUserView.init(model, stage); // <-- passar Stage
                break;

            case "3": // Sair
                if (stage != null) stage.close();
                break;
        }
    }

}

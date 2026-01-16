package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.MainView;
import ufc.br.view.NewUserView;

public class NewUserController {

    private Model model;
    private NewUserView view;
    private Stage stage;

    // Inicializa controller com Stage compartilhado
    public void init(Model model, NewUserView view, Stage stage) {
        if(model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    public void handleEvent(String event) {
        switch(event) {
            case "OK":
                // Cadastra usuário no modelo
                model.setUsuario(view.getNome(), view.getLogin(), view.getSenha());

                // Feedback para usuário
                view.exibeMSG("Usuário cadastrado com sucesso!");

                // Pode trocar para tela de login ou UserView aqui se desejar
                break;

            case "VOLTA":
                MainView mainview = new MainView();
                mainview.init(model, stage);
                break;
        }
    }
}

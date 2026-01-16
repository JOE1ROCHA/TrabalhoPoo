package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.NewTrabalhoView;
import ufc.br.view.TrabalhosView;
import ufc.br.view.MainView;
import ufc.br.view.UserView;

import java.util.List;

public class UserController {

    private Model model;
    private UserView view;
    private Stage stage;

    public void init(Model model, UserView view, Stage stage) {
        if(model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    public void handleEvent(String event) {
        switch(event) {
            case "LOGOUT":
                model.deslogarUsuario();
                MainView mainView = new MainView();
                mainView.init(model, stage); // <-- passa o Stage atual
                break;

            case "TRABALHOS":
                List<?> trabalhos = model.getListaTrabalhos(model.getUsuarioAutenticado());
                if(trabalhos != null && !trabalhos.isEmpty()) {
                    TrabalhosView trabalhosView = new TrabalhosView();
                    trabalhosView.init(model, stage); // <-- Stage também aqui
                } else {
                    NewTrabalhoView newTrabalhoView = new NewTrabalhoView();
                    newTrabalhoView.init(model, stage);
                }
                break;

            case "NOVO_TRABALHO":
                NewTrabalhoView novoTrabalhoView = new NewTrabalhoView();
                novoTrabalhoView.init(model, stage);
                break;

        }
    }
}

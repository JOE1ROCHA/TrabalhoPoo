package ufc.br.controller;

import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.NewUserView;

public class NewUserController implements Observer {
    private Model model;
    private NewUserView view;

    public void init(Model model, NewUserView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                model.setUsuario(view.getNome(), view.getLogin(),view.getSenha());
                model.detachObserver(this);
                break;
        }
    }

    public void update() {
    }
}

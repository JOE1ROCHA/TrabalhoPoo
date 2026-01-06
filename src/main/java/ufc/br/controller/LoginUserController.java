package ufc.br.controller;

import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.LoginUserView;
import ufc.br.view.UserView;

public class LoginUserController implements Observer {
    private Model model;
    private LoginUserView view;

    public void init(Model model, LoginUserView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
                if (!autenticado) {
                    view.exibeMSG("ERRO: Usuario e/ou Senha invalidos!");
                } else {
                    UserView view3 = new UserView(); // ir para tela de usuario
                    view3.init(model);
                }
                model.detachObserver(this);
                break;
        }
    }

    public void update() {
    }
}

package ufc.br.controller;

import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.NewTrabalhoView;
import ufc.br.view.TrabalhosView;
import ufc.br.view.UserView;
import ufc.br.view.MainView;

public class UserController implements Observer {
    private Model model;    // Guarda o modelo a ser utilizado
    private UserView view;    // Guarda a view a ser controlada

    public void init(Model model, UserView userView) {
        if (model != null && userView != null){
            this.model = model;
            this.view = userView;
        }
    }


    public void update() {

    }

    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
    public void handleEvent(String event) {
        switch (event) {
            case "1":
                model.deslogarUsuario();
                MainView view3 = new MainView();
                view3.init(model);
                break;
            case "2":
                if(model.getListaTrabalhos(model.getUsuarioAutenticado()).size() > 0) {
                    TrabalhosView listaTrabalhos = new TrabalhosView();
                    listaTrabalhos.init(model);
                }
                else{
                    System.out.println("LISTA VAZIA!!");
                    return;
                }
                break;
            case "3":
                NewTrabalhoView novoTrabalhoView = new NewTrabalhoView();
                novoTrabalhoView.init(model);
                break;    // finalizar sistema
        }
    }
}

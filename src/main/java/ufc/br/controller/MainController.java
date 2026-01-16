package ufc.br.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.LoginUserView;
import ufc.br.view.MainView;
import ufc.br.view.NewUserView;
import javafx.scene.control.Label;

public class MainController implements Observer {
    private Model model;	// Guarda o modelo a ser utilizado
    private MainView view;	// Guarda a view a ser controlada

    /*
     * Inicialização do controller da view principal
     */
    public void init(Model model, MainView view) {
        if (model != null && view != null){
            this.model = model;  // Guarda o modelo
            this.view = view;	 // Guarda a view
        }
    }

    /*
     * O controller só implementa o update se for necessário
     */
    public void update() {

    }
    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
    @FXML
    protected void logar() {
        LoginUserView view3 = new LoginUserView(); // ir para tela de login
        view3.init(model);
        System.out.println("entrou");
    }
//    public void handleEvent(String event) {
//        switch (event) {
//            case "1" : if (model.getUsuarioAutenticado() == "") {
//                LoginUserView view3 = new LoginUserView(); // ir para tela de login
//                view3.init(model);
//            } else {
//                model.deslogarUsuario();
//            }
//                break;
//            case "2" : NewUserView view2 = new NewUserView(); // ir para tela de cadastro de usuário
//                view2.init(model);
//                break;
//            case "3" : view.finalizarSistema(); break;	// finalizar sistema
//        }
//    }
}
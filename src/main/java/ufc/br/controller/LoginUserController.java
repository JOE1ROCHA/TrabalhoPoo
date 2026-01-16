package ufc.br.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.LoginUserView;
import ufc.br.view.MainView;

import java.awt.*;
import java.io.IOException;

public class LoginUserController implements Observer {
    private Model model;
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;
//    private LoginUserView view;

    public void init(Model model, LoginUserView view) {
        if (model != null && view != null){
            this.model = model;
//            this.view = view;
            model.attachObserver(this);
        }
    }

    @FXML
    private void userView(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/UserView.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );
    }
   public void handleEvent(String event) {
////        switch (event) {
////            case "OK" :
////                boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
////                if (!autenticado) {
////                    view.exibeMSG("ERRO: Usuario e/ou Senha invalidos!");
////                } else {
////                    UserView view3 = new UserView(); // ir para tela de usuario
////                    view3.init(model);
////                }
////                model.detachObserver(this);
////                break;
////        }
    }
    @FXML
    public void autenticarLogin(ActionEvent event)throws IOException{
        if(model.autenticarUsuario(login.getText(), senha.getText())){
            userView(event);
        }
    }
    public void update() {
    }
}

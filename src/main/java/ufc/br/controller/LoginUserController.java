package ufc.br.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.LoginUserView;
import ufc.br.view.MainView;

import java.io.IOException;

public class LoginUserController implements Observer {
    Model model = Model.getInstancia();
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;
//    private LoginUserView view;


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

    @FXML
    public void autenticarLogin(ActionEvent event)throws IOException{
        if(model.autenticarUsuario(login.getText(), senha.getText())){
            userView(event);
        }
    }
    public void update() {
    }
}
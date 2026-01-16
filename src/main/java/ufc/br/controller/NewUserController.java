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
import ufc.br.view.NewUserView;
import javafx.scene.control.TextField;
import java.io.IOException;

public class NewUserController implements Observer {
    private NewUserView view;
    private Model model;
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;
//    private LoginUserView view;
    @FXML
    private TextField nome;

    public void init(Model model, NewUserView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    private void cadastroUser(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/LoginUserView.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :

                model.detachObserver(this);
                break;
        }
    }
    public void update() {
    }
    @FXML
    public void autenticarCadastro(ActionEvent event) throws IOException{
        model.setUsuario(nome.getText(), login.getText(),senha.getText());
        cadastroUser(event);
    }
}

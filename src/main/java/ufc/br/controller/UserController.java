package ufc.br.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.NewTrabalhoView;
import ufc.br.view.TrabalhosView;
import ufc.br.view.UserView;
import ufc.br.view.MainView;

import java.io.IOException;
import java.util.Scanner;

public class UserController implements Observer {
    private Model model = Model.getInstancia();   // Guarda o modelo a ser utilizado
    private UserView view;    // Guarda a view a ser controlada

    @FXML
    public void irParaListaTrabalhos(ActionEvent event) throws IOException {
        // Verifica se há trabalhos antes de mudar de tela
        if (model.getListaTrabalhos(model.getUsuarioAutenticado()) != null &&
                !model.getListaTrabalhos(model.getUsuarioAutenticado()).isEmpty()) {

            navegar(event, "/ufc/br/view/TrabalhosView.fxml");
        } else {
            // Substitui o Scanner por um Alerta do JavaFX
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText(null);
            alert.setContentText("Ainda não há trabalhos cadastrados!");
            alert.showAndWait();
        }
    }

    @FXML
    public void irParaNovoTrabalho(ActionEvent event) throws IOException {
        navegar(event, "/ufc/br/view/NewTrabalhoView.fxml");
    }

    @FXML
    public void deslogar(ActionEvent event) throws IOException {
        model.deslogarUsuario();
        navegar(event, "/ufc/br/view/MainView.fxml");
    }

    // Método utilitário para trocar de tela
    private void navegar(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        // Mantém o estilo CSS se houver
        String css = getClass().getResource("/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update() {
        // Atualize elementos da UI aqui se o Model mudar enquanto esta tela estiver aberta
    }
}
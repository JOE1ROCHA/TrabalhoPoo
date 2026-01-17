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

    @FXML
    public void initialize() {
        Model modelo = Model.getInstancia();
        String logado = modelo.getUsuarioAutenticado();

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
    public void autenticarCadastro(ActionEvent event) throws IOException {
        // 1. Captura os dados digitados na tela
        String nomeUsuario = nome.getText();
        String loginUsuario = login.getText();
        String senhaUsuario = senha.getText();

        // 2. Envia para o Model (que está na memória)
        Model.getInstancia().setUsuario(nomeUsuario, loginUsuario, senhaUsuario);

        // 3. Feedback visual (Opcional, mas recomendado)
        System.out.println("Usuário " + loginUsuario + " cadastrado com sucesso!");

        // 4. Redireciona para a tela de Login
        irParaTelaDeLogin(event);
    }

    private void irParaTelaDeLogin(ActionEvent event) throws IOException {
        // Carrega o FXML do Login
        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/LoginUserView.fxml"));

        // Identifica a janela atual (Stage)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Troca o conteúdo da janela
        stage.setScene(new Scene(root));
        stage.show();
    }
}
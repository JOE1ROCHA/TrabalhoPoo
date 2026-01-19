package ufc.br.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.NewTrabalhoView;
import javafx.scene.control.TextField;
import ufc.br.view.TrabalhosView;

import java.io.IOException;

public class NewTrabalhoController implements Observer {
    private Model model;
    private NewTrabalhoView view;

    @FXML
    private TextField nome;
    @FXML
    private TextArea descricao;

    @FXML
    public void initialize() {
        model = Model.getInstancia();
    }

    public void handleEvent(String event) {
//        switch (event) {
//            case "OK" :
//                model.setTrabalho(view.getDescricao(), view.getAutor(),view.getResponsavel(), view.getTitulo());
//                model.detachObserver(this);
//                TrabalhosView listaTrabalhos = new TrabalhosView();
//                listaTrabalhos.init(model);
//                break;
//        }
    }
    private void cadastroTrabalho(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/UserView.fxml"));

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void autenticarCadastro(ActionEvent event) throws IOException {
        // 1. Captura os dados digitados na tela
        String nomeTrabalho = nome.getText();
        String descricaoTrabalho = descricao.getText();

        // 2. Envia para o Model (que está na memória)
        Model.getInstancia().setTrabalho(descricaoTrabalho,model.getUsuarioLogin(),model.getUsuarioLogin(),nomeTrabalho);

        // 3. Feedback visual (Opcional, mas recomendado)
        System.out.println("Trabalho " + nomeTrabalho + " cadastrado com sucesso!");

        // 4. Redireciona para a tela de Trabalhos
        irParaTelaTrabalhos(event);
    }

    public void irParaTelaTrabalhos(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/TrabalhosView.fxml"));

        // Identifica a janela atual (Stage)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Troca o conteúdo da janela
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void update() {
    }
}

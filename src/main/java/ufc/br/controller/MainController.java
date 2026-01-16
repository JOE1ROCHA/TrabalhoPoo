package ufc.br.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.MainView;

import java.io.IOException;

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
    protected void logar(ActionEvent event) throws IOException {
        // 1. Carrega o arquivo FXML da nova tela
        // Certifique-se de que o caminho está correto (ex: /view/cadastro.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/LoginUserView.fxml"));

        // 2. Pega o Stage (janela) atual a partir do botão que foi clicado
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 3. Define a nova cena no Stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );
    }

    @FXML
    protected void cadastroUser(ActionEvent event) throws IOException {
        // 1. Carrega o arquivo FXML da nova tela
        // Certifique-se de que o caminho está correto (ex: /view/cadastro.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("/ufc/br/view/NewUserView.fxml"));

        // 2. Pega o Stage (janela) atual a partir do botão que foi clicado
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 3. Define a nova cena no Stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );
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
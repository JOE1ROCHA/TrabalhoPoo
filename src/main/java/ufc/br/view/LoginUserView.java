package ufc.br.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.LoginUserController;
import ufc.br.model.Model;
import ufc.br.model.Observer;

public class LoginUserView implements Observer {

    private Model model;
    private LoginUserController controller;
    private String login;
    private String senha;

    private Stage stage;
    private Scene scene;
    private VBox root;

    // Inicializa a view no mesmo Stage
    public void init(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;

        controller = new LoginUserController();
        controller.init(model, this, stage);

        model.attachObserver(this);

        buildUI();
        stage.setScene(scene);
        stage.show();
    }

    // Constrói a interface JavaFX
    private void buildUI() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label title = new Label("TELA DE LOGIN");
        Label msgLabel = new Label(); // Para exibir mensagens (como login incorreto)

        TextField loginField = new TextField();
        loginField.setPromptText("Login");

        PasswordField senhaField = new PasswordField();
        senhaField.setPromptText("Senha");

        Button okBtn = new Button("Entrar");
        okBtn.setOnAction(e -> {
            login = loginField.getText();
            senha = senhaField.getText();
            controller.handleEvent("OK"); // evento de login
        });

        Button voltarBtn = new Button("Voltar");
        voltarBtn.setOnAction(e -> controller.handleEvent("VOLTA")); // voltar para MainView

        root.getChildren().addAll(title, loginField, senhaField, okBtn, voltarBtn, msgLabel);

        scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
    }

    @Override
    public void update() {
        // Pode ser usado para atualizar mensagens de erro ou estado de login
    }

    // Método para exibir mensagem na tela
    public void exibeMSG(String msg) {
        if (root != null && root.getChildren().size() > 5) {
            ((Label) root.getChildren().get(5)).setText(msg);
        }
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
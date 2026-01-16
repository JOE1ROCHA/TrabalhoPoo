package ufc.br.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.NewUserController;
import ufc.br.model.Model;
import ufc.br.model.Observer;

public class NewUserView implements Observer {

    private Model model;
    private NewUserController controller;
    private Stage stage;
    private Scene scene;
    private VBox root;

    private String nome;
    private String login;
    private String senha;

    private TextField nomeField;
    private TextField loginField;
    private PasswordField senhaField;
    private Label msgLabel;

    public void init(Model model, Stage stage) {
        if(model != null && stage != null) {
            this.model = model;
            this.stage = stage; // agora o Stage não é mais nulo

            controller = new NewUserController();
            controller.init(model, this, stage);

            model.attachObserver(this);

            buildUI();
            stage.setScene(scene);
            stage.show();
        }
    }

    private void buildUI() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("TELA CADASTRAR USUÁRIO");

        nomeField = new TextField();
        nomeField.setPromptText("Nome");

        loginField = new TextField();
        loginField.setPromptText("Login");

        senhaField = new PasswordField();
        senhaField.setPromptText("Senha");

        Button okBtn = new Button("Cadastrar");
        okBtn.setOnAction(e -> {
            nome = nomeField.getText();
            login = loginField.getText();
            senha = senhaField.getText();
            controller.handleEvent("OK");
        });

        Button voltarBtn = new Button("Voltar");
        voltarBtn.setOnAction(e -> controller.handleEvent("VOLTA"));

        msgLabel = new Label();

        root.getChildren().addAll(titleLabel, nomeField, loginField, senhaField, okBtn, voltarBtn, msgLabel);

        scene = new Scene(root, 400, 350);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
    }

    @Override
    public void update() {
        // Pode atualizar mensagens do modelo aqui
    }

    public void exibeMSG(String msg) {
        if(msgLabel != null) {
            msgLabel.setText(msg);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}

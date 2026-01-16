package ufc.br.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.MainController;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.ui.StageManager;

public class MainView implements Observer {
    private Model model;
    private MainController controller;
    private int totalUsers;
    private String usuarioLogado;

    private Scene mainScene;
    private VBox root;
    private Stage stage; // <- guardar o Stage aqui

    public void init(Model model, Stage stage) { // recebe Stage
        this.model = model;
        this.stage = stage; // agora stage não é mais nulo
        controller = new MainController();
        controller.init(model, this, stage);
        model.attachObserver(this);

        buildUI();

        // Mostra a cena no Stage
        stage.setScene(mainScene);
        stage.show();
    }

    private void buildUI() {
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Label title = new Label("TELA INICIAL DO SISTEMA TESTE");
        title.getStyleClass().add("title");

        Label totalUsersLabel = new Label("Total Usuários: " + totalUsers);
        totalUsersLabel.getStyleClass().add("info");

        Button loginBtn = new Button("Fazer Login");
        loginBtn.setId("login-btn");
        Button cadastroBtn = new Button("Fazer Cadastro");
        Button sairBtn = new Button("Sair");

        loginBtn.setOnAction(e -> controller.handleEvent("1"));
        cadastroBtn.setOnAction(e -> controller.handleEvent("2"));
        sairBtn.setOnAction(e -> stage.close());

        root.getChildren().addAll(
                title,
                totalUsersLabel,
                loginBtn,
                cadastroBtn,
                sairBtn
        );

        mainScene = new Scene(root, 900, 600);

        mainScene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void update() {
        totalUsers = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
        if (root != null && root.getChildren().size() > 1) {
            ((Label) root.getChildren().get(1)).setText("Total Usuários: " + totalUsers);
        }
    }
    public Scene getScene() {
        return mainScene;
    }
}
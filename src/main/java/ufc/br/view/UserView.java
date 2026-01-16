package ufc.br.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.UserController;
import ufc.br.model.Model;

public class UserView {

    private Model model;
    private UserController controller;
    private Stage stage;
    private Scene scene;
    private VBox root;

    private Label usuarioLabel;
    private Button logoutBtn;
    private Button verTrabalhosBtn;
    private Button cadastrarTrabalhoBtn;

    public void init(Model model, Stage stage) {
        if(model != null && stage != null) {
            this.model = model;
            this.stage = stage;

            controller = new UserController();
            controller.init(model, this, stage);

            buildUI();

            stage.setScene(scene);
            stage.show();
        }
    }

    private void buildUI() {
        root = new VBox(15);
        root.setAlignment(Pos.CENTER);

        usuarioLabel = new Label("Usuário logado: " + model.getUsuarioLogin());

        logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> controller.handleEvent("LOGOUT"));

        verTrabalhosBtn = new Button("Ver meus trabalhos");
        verTrabalhosBtn.setOnAction(e -> controller.handleEvent("TRABALHOS"));

        cadastrarTrabalhoBtn = new Button("Cadastrar novo trabalho");
        cadastrarTrabalhoBtn.setOnAction(e -> controller.handleEvent("NOVO_TRABALHO"));

        root.getChildren().addAll(usuarioLabel, verTrabalhosBtn, cadastrarTrabalhoBtn, logoutBtn);

        scene = new Scene(root, 400, 300);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
    }
}

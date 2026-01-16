package ufc.br.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.NewTarefaController;
import ufc.br.model.Model;
import ufc.br.model.Observer;

public class NewTarefaView implements Observer {

    private NewTarefaController controller;
    private Model model;
    private Stage stage;
    private Scene scene;
    private VBox root;

    private String titulo;
    private String descricao;
    private String responsavel;

    private TextField tituloField;
    private TextArea descricaoField;
    private TextField responsavelField;
    private Label msgLabel;

    public void init(Model model, Stage stage) {
        if(model != null && stage != null) {
            this.model = model;

            controller = new NewTarefaController();
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

        Label titleLabel = new Label("TELA CADASTRAR TAREFA");

        tituloField = new TextField();
        tituloField.setPromptText("Título");

        descricaoField = new TextArea();
        descricaoField.setPromptText("Descrição");
        descricaoField.setPrefRowCount(4);

        responsavelField = new TextField();
        responsavelField.setPromptText("Responsável");

        Button okBtn = new Button("Cadastrar");
        okBtn.setOnAction(e -> {
            titulo = tituloField.getText();
            descricao = descricaoField.getText();
            responsavel = responsavelField.getText();
            controller.handleEvent("OK");
        });

        Button voltarBtn = new Button("Voltar");
        voltarBtn.setOnAction(e -> controller.handleEvent("VOLTA"));

        msgLabel = new Label();

        root.getChildren().addAll(titleLabel, tituloField, descricaoField, responsavelField, okBtn, voltarBtn, msgLabel);

        scene = new Scene(root, 400, 400);
    }

    @Override
    public void update() {
        // Atualizações do modelo podem alterar a mensagem
    }

    public void exibeMSG(String msg) {
        if(msgLabel != null) {
            msgLabel.setText(msg);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }
}

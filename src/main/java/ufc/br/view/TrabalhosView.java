package ufc.br.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.TrabalhosController;
import ufc.br.model.Model;
import ufc.br.model.Trabalho;

import java.util.List;

public class TrabalhosView {

    private Model model;
    private TrabalhosController controller;
    private Stage stage;
    private Scene scene;
    private VBox root;

    private ListView<String> listView;
    private Label detalhesLabel;
    private Button voltarBtn;
    private Button verTarefasBtn;
    private Button excluirBtn;
    private ObservableList<String> trabalhosObservable;

    public void init(Model model, Stage stage) {
        if(model != null && stage != null) {
            this.model = model;
            this.stage = stage;

            controller = new TrabalhosController();
            controller.init(model, this, stage);

            buildUI();
            atualizarLista();

            stage.setScene(scene);
            stage.show();
        }
    }

    private void buildUI() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("LISTA DE TRABALHOS");

        listView = new ListView<>();
        trabalhosObservable = FXCollections.observableArrayList();
        listView.setItems(trabalhosObservable);

        detalhesLabel = new Label("Selecione um trabalho para ver detalhes");

        voltarBtn = new Button("Voltar");
        voltarBtn.setOnAction(e -> controller.handleEvent("VOLTA"));

        verTarefasBtn = new Button("Ver Minhas Tarefas");
        verTarefasBtn.setOnAction(e -> controller.handleEvent("TAREFAS"));

        excluirBtn = new Button("Excluir Trabalho");
        excluirBtn.setOnAction(e -> controller.handleEvent("EXCLUIR"));

        // Ao selecionar um trabalho, mostra detalhes e define trabalhoSelecionado
        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            int idx = newVal.intValue();
            if(idx >= 0) {
                Trabalho trabalho = model.getListaTrabalhos(model.getUsuarioAutenticado()).get(idx);
                model.setTrabalhoSelecionado(trabalho);
                detalhesLabel.setText("Título: " + trabalho.getTitulo() + "\nDescrição: " + trabalho.getDescricao());
            }
        });

        root.getChildren().addAll(titleLabel, listView, detalhesLabel, verTarefasBtn, excluirBtn, voltarBtn);

        scene = new Scene(root, 400, 500);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
    }

    public void atualizarLista() {
        trabalhosObservable.clear();
        List<Trabalho> lista = model.getListaTrabalhos(model.getUsuarioAutenticado());
        if(lista != null) {
            for(Trabalho t : lista) {
                trabalhosObservable.add(t.getTitulo());
            }
        }
    }
}

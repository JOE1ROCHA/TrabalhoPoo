package ufc.br.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ufc.br.controller.TarefasController;
import ufc.br.model.ItensDeTrabalho;
import ufc.br.model.Model;

import java.util.List;

public class TarefasView {

    private Model model;
    private TarefasController controller;
    private Stage stage;
    private Scene scene;
    private VBox root;

    private ListView<String> listView;
    private Label detalhesLabel;
    private Button voltarBtn;
    private Button cadastrarBtn;
    private Button excluirBtn;
    private ObservableList<String> tarefasObservable;

    public void init(Model model, Stage stage) {
        if(model != null && stage != null) {
            this.model = model;
            this.stage = stage;

            controller = new TarefasController();
            controller.init(model, this, stage);

            //model.attachObserver(controller); // controller pode reagir a atualizações

            buildUI();
            atualizarLista();

            stage.setScene(scene);
            stage.show();
        }
    }

    private void buildUI() {
        root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("LISTA DE TAREFAS");

        listView = new ListView<>();
        tarefasObservable = FXCollections.observableArrayList(String.valueOf(model.getTrabalhoSelecionado()));
        listView.setItems(tarefasObservable);

        detalhesLabel = new Label("Selecione uma tarefa para ver detalhes");

        voltarBtn = new Button("Voltar");
        voltarBtn.setOnAction(e -> controller.handleEvent("VOLTA"));

        cadastrarBtn = new Button("Cadastrar Tarefa");
        cadastrarBtn.setOnAction(e -> controller.handleEvent("CADASTRAR"));

        excluirBtn = new Button("Excluir Tarefa");
        excluirBtn.setOnAction(e -> controller.handleEvent("EXCLUIR"));

        // Ao selecionar uma tarefa, mostrar detalhes
        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            int idx = newVal.intValue();
            if(idx >= 0) {
                ItensDeTrabalho iten = model.getListaTarefas(model.getTrabalhoSelecionado().getTitulo()).get(idx);
                model.setTarefaSelecionada(iten);
                detalhesLabel.setText("Descrição: " + iten.getDescricao() + "\nResponsável: " + iten.getResponsavel());
            }
        });

        root.getChildren().addAll(titleLabel, listView, detalhesLabel, cadastrarBtn, excluirBtn, voltarBtn);

        scene = new Scene(root, 400, 500);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
    }

    public void atualizarLista() {
        tarefasObservable.clear();
        List<ItensDeTrabalho> lista = model.getListaTarefas(model.getTrabalhoSelecionado().getTitulo());
        if(lista != null) {
            for(ItensDeTrabalho item : lista) {
                tarefasObservable.add(item.getTitulo());
            }
        }
    }
}
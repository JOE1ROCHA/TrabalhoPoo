package ufc.br.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ufc.br.model.ItensDeTrabalho;
import ufc.br.model.Model;
import ufc.br.model.Trabalho;
import ufc.br.view.TrabalhosView;

import java.util.List;

public class TrabalhosController {
    private Model model = Model.getInstancia();    // Guarda o modelo a ser utilizado
    private TrabalhosView view;    // Guarda a view a ser controlada

    public TrabalhosController() {

    }

    @FXML
    private ListView<Trabalho> listTrabalhos;

    @FXML
    public void initialize() {

        listTrabalhos.setCellFactory(param -> new ListCell<Trabalho>() {

            // Cabeçalho (sempre visível)
            private final Label labelTitulo = new Label();
            private final ProgressBar progressBar = new ProgressBar();
            private final HBox header = new HBox(10);

            // Conteúdo expandido
            private final ListView<ItensDeTrabalho> listaTarefas = new ListView<>();
            private final VBox container = new VBox(5);
            private final Label labelVazio = new Label("Nenhuma tarefa cadastrada");

            private boolean expandido = false;

            {
                // Header
                labelTitulo.setPrefWidth(200);
                progressBar.setPrefWidth(180);

                header.setAlignment(Pos.CENTER_LEFT);
                header.getChildren().addAll(labelTitulo, progressBar);

                // Lista interna
                listaTarefas.setPrefHeight(120);

                // Label de lista vazia
                labelVazio.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
                labelVazio.setPadding(new Insets(5, 0, 5, 10));

                // Container principal
                container.getChildren().add(header);

                // Clique para expandir/recolher
                header.setOnMouseClicked(e -> {
                    expandido = !expandido;
                    atualizarVisibilidade();
                });
            }


            private void atualizarVisibilidade() {
                if (expandido) {
                    container.getChildren().remove(listaTarefas);
                    container.getChildren().remove(labelVazio);

                    if (listaTarefas.getItems().isEmpty()) {
                        container.getChildren().add(labelVazio);
                    } else {
                        container.getChildren().add(listaTarefas);
                    }
                } else {
                    container.getChildren().remove(listaTarefas);
                    container.getChildren().remove(labelVazio);
                }
            }

            @Override
            protected void updateItem(Trabalho trabalho, boolean empty) {
                super.updateItem(trabalho, empty);

                if (empty || trabalho == null) {
                    setText(null);
                    setGraphic(null);
                    return;
                }

                labelTitulo.setText(trabalho.getTitulo());

                // ProgressBar espera valor de 0.0 a 1.0
                progressBar.setProgress(trabalho.porcentagemConluido() / 100.0);

                listaTarefas.getItems().setAll(
                        trabalho.getListaTarefas() == null
                                ? List.of()
                                : trabalho.getListaTarefas()
                );

                expandido = false;
                atualizarVisibilidade();

                setText(null);
                setGraphic(container);
            }


        });

        listTrabalhos.getItems().addAll(model.getListaTrabalhos(model.getUsuarioAutenticado()));
    }

    public void trabalhoSelecionado() {
        listTrabalhos.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && event.isPrimaryButtonDown()) {
                Trabalho selecionado = listTrabalhos.getSelectionModel().getSelectedItem();

                if (selecionado != null) {
                    System.out.println("Selecionado: " + selecionado.getTitulo());
                    // Abrir detalhes ou chamar outra view
                }
            }
        });
    }


    public void update() {

    }
}

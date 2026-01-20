package ufc.br.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import ufc.br.model.Model;
import ufc.br.model.Trabalho;
import ufc.br.view.TrabalhosView;

import java.io.IOException;

public class TrabalhosController {
    private Model model = Model.getInstancia();    // Guarda o modelo a ser utilizado
    private TrabalhosView view;    // Guarda a view a ser controlada

    @FXML
    private ListView<Trabalho>listTrabalhos;

    @FXML
    public void initialize() {
        // Popula a lista ao iniciar
        listTrabalhos.setCellFactory(param -> new ListCell<Trabalho>() {
            @Override
            protected void updateItem(Trabalho trabalho, boolean empty) {
                super.updateItem(trabalho, empty);
                if (empty || trabalho == null) {
                    setText(null);
                } else {
                    setText(trabalho.getTitulo());
                }
            }
        });

        listTrabalhos.getItems().addAll(model.getListaTrabalhos(model.getUsuarioAutenticado()));
    }


    public void update() {

    }

    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
    public void handleEvent(String event) {
        switch (event) {
//            case "1":
//                TrabalhosView listaTrabalhos = new TrabalhosView();
//                listaTrabalhos.init(model);
//                break;
//            case "2":
//                TarefasView itensTrabalhos = new TarefasView();
//                itensTrabalhos.init(model);
//                break;
//            case "3":
//                model.removerTrabalho(model.getUsuarioAutenticado(), model.getTrabalhoSelecionado().getTitulo());
//                break;    // finalizar sistema
        }
    }
}

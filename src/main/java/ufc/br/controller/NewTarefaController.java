package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.MainView;
import ufc.br.view.NewTarefaView;
import ufc.br.view.TarefasView;
import ufc.br.view.TrabalhosView;

public class NewTarefaController {
    private Model model;
    private NewTarefaView view;
    private Stage stage;

    // Inicializa controller com Stage compartilhado
    public void init(Model model, NewTarefaView view, Stage stage) {
        if(model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK":
                // Cadastra a tarefa no modelo
                model.setTarefas(view.getTitulo(), view.getDescricao(), view.getResponsavel());

                // Troca para TarefasView no mesmo Stage
                TarefasView tarefasView = new TarefasView();
                tarefasView.init(model, stage);
                break;

            case "VOLTA":
                TrabalhosView trabalho = new TrabalhosView();
                trabalho.init(model, stage);
                break;
        }
    }
}

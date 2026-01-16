package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.TarefasView;
import ufc.br.view.TrabalhosView;
import ufc.br.view.UserView;

public class TrabalhosController {

    private Model model;
    private TrabalhosView view;
    private Stage stage;

    public void init(Model model, TrabalhosView view, Stage stage) {
        if(model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    public void handleEvent(String event) {
        switch(event) {
            case "VOLTA":
                // Volta para UserView
                UserView userView = new UserView();
                userView.init(model, stage);
                break;

            case "TAREFAS":
                // Abre TarefasView do trabalho selecionado
                if(model.getTrabalhoSelecionado() != null) {
                    TarefasView tarefasView = new TarefasView();
                    tarefasView.init(model, stage);
                }
                break;

            case "EXCLUIR":
                if(model.getTrabalhoSelecionado() != null) {
                    model.removerTrabalho(model.getUsuarioAutenticado(), model.getTrabalhoSelecionado().getTitulo());
                    view.atualizarLista(); // Atualiza ListView após exclusão
                }
                break;
        }
    }
}

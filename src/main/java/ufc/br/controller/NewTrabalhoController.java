package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.NewTrabalhoView;
import ufc.br.view.TrabalhosView;

public class NewTrabalhoController {

    private Model model;
    private NewTrabalhoView view;
    private Stage stage;

    // Inicializa controller com Stage compartilhado
    public void init(Model model, NewTrabalhoView view, Stage stage) {
        if(model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    public void handleEvent(String event) {
        switch(event) {
            case "OK":
                // Cadastra o trabalho no modelo
                model.setTrabalho(view.getDescricao(), view.getAutor(), view.getResponsavel(), view.getTitulo());

                // Troca para a tela de lista de trabalhos no mesmo Stage
                TrabalhosView trabalhosView = new TrabalhosView();
                trabalhosView.init(model, stage);
                break;

            case "VOLTA":
                // Volta para a tela anterior (pode ser UserView ou MainView)
                // Aqui precisaremos que NewTrabalhoView tenha referência da Scene anterior
                break;
        }
    }
}

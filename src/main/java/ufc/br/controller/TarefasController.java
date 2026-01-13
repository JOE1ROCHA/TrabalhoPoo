package ufc.br.controller;

import ufc.br.model.Model;
import ufc.br.view.TarefasView;

public class TarefasController {
    private Model model;    // Guarda o modelo a ser utilizado
    private TarefasView view;    // Guarda a view a ser controlada

    public void init(Model model, TarefasView tarefasView) {
        if (model != null && tarefasView != null){
            this.model = model;
            this.view = tarefasView;
        }
    }

    public void update() {

    }

    /*
     * Utilizado para verificar o que deve ser feito em resposta ao evento que aconteceu na view
     */
    public void handleEvent(String event) {
        switch (event) {
            case "1":
                TarefasView listaItens = new TarefasView();
                listaItens.init(model);
                break;
            case "2":
                model.removerTarefa(model.getTrabalhoSelecionado().getResponsavel(), model.getTrabalhoSelecionado().getTitulo());
                break;
        }
    }
}


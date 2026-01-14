package ufc.br.controller;

import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.view.NewTarefaView;
import ufc.br.view.TarefasView;
import ufc.br.view.TrabalhosView;

public class NewTarefaController implements Observer {
    private Model model;
    private NewTarefaView view;

    public void init(Model model, NewTarefaView view) {
        if(model != null && view!= null) {
            this.model = model;
            this.view = view;
        }
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                model.setTarefas(view.getTitulo(),view.getDescricao(),view.getResponsavel());
                model.detachObserver(this);
                TarefasView listaTarefas = new TarefasView();
                listaTarefas.init(model);
                break;
        }
    }

    public void update() {
    }
}

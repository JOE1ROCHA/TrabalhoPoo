package ufc.br.controller;

import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.model.ItensDeTrabalho;
import ufc.br.view.NewTarefaView;
import ufc.br.view.TarefasView;
import ufc.br.view.TrabalhosView;

import java.util.List;

public class TarefasController {

    private Model model;
    private TarefasView view;
    private Stage stage;

    public void init(Model model, TarefasView view, Stage stage) {
        if(model != null && view != null && stage != null) {
            this.model = model;
            this.view = view;
            this.stage = stage;
        }
    }

    public void handleEvent(String event) {
        switch(event) {
            case "VOLTA":
                // Volta para a tela de trabalhos
                TrabalhosView trabalhosView = new TrabalhosView();
                trabalhosView.init(model, stage);
                break;

            case "CADASTRAR":
                // Abre tela de cadastro de nova tarefa
                NewTarefaView newTarefaView = new NewTarefaView();
                newTarefaView.init(model, stage);
                break;

            case "EXCLUIR":
                // Remove a tarefa selecionada
                ItensDeTrabalho selecionada = model.getTarefaSelecionada();
                if(selecionada != null && model.getTrabalhoSelecionado() != null) {
                    model.removerTarefa(model.getTrabalhoSelecionado().getTitulo(), selecionada.getTitulo());
                    view.atualizarLista(); // Atualiza ListView após exclusão
                }
                break;
        }
    }
}

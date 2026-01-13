package ufc.br.controller;
import ufc.br.model.Model;
import ufc.br.view.TarefasView;
import ufc.br.view.TrabalhosView;

public class TrabalhosController {
    private Model model;    // Guarda o modelo a ser utilizado
    private TrabalhosView view;    // Guarda a view a ser controlada

    public void init(Model model, TrabalhosView trabalhoView) {
        if (model != null && trabalhoView != null){
            this.model = model;
            this.view = trabalhoView;
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
                TrabalhosView listaTrabalhos = new TrabalhosView();
                listaTrabalhos.init(model);
                break;
            case "2":
                TarefasView itensTrabalhos = new TarefasView();
                itensTrabalhos.init(model);
                break;
            case "3":
                model.removerTrabalho(model.getUsuarioAutenticado(), model.getTrabalhoSelecionado().getTitulo());
                break;    // finalizar sistema
        }
    }
}

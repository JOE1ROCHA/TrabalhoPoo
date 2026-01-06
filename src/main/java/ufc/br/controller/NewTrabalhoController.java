package ufc.br.controller;
import ufc.br.model.Model;
import ufc.br.model.Observer;
import ufc.br.model.Usuario;
import ufc.br.model.Trabalho;
import ufc.br.view.NewTrabalhoView;

public class NewTrabalhoController implements Observer {
    private Model model;
    private NewTrabalhoView view;

    public void init(Model model, NewTrabalhoView view) {
        if(model != null && view!= null) {
            this.model = model;
            this.view = view;
        }
    }
    public void handleEvent(String event) {
//        switch (event) {
//            case "OK" :
//                model.(view.getTitulo(), view.getAutor(),view.getResponsavel());
//                model.addTrabalho(this);
//                break;
//        }
    }

    public void update() {
    }
}

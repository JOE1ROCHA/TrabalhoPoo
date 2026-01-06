package ufc.br.controller;
import ufc.br.model.Usuario;
import ufc.br.model.Trabalho;
import ufc.br.view.NewTrabalhoView;

public class NewTrabalhoController implements Observer {
    private Trabalho model;
    private NewTrabalhoView view;

    public void init(Usuario model, NewTrabalhoView view) {
        this.model = model;
        this.view = view;
        model.addTrabalho(this);
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                model.(view.getTitulo(), view.getAutor(),view.getResponsavel());
                model.addTrabalho(this);
                break;
        }
    }

    public void update() {
    }
}

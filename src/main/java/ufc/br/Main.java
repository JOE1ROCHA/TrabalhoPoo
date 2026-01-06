package ufc.br;

import ufc.br.model.Model;
import ufc.br.view.MainView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Model model = Model.getInstancia();
        MainView view = new MainView();
        view.init(model);
    }
}
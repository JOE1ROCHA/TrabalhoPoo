package ufc.br;

import ufc.br.model.Model;
import ufc.br.view.MainView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Model model = Model.getInstancia();
        usuarios(model);
        trabalhos(model);
        MainView view = new MainView();
        view.init(model);
    }
    public static void usuarios(Model model){
        model.setUsuario("eu", "eu", "eu");
        model.setUsuario("vc", "vc", "vc");
    }
    public static void trabalhos(Model model){
        model.setTrabalho("teste", "eu", "eu","algo");
        model.setTrabalho("teste", "eu", "eu","algo2");
        model.setTrabalho("teste", "eu", "eu","algo3");
    }
}
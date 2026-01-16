package ufc.br;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ufc.br.model.Model;
import ufc.br.view.MainView;

public class Main extends Application {

    private Model model;

    @Override
    public void start(Stage primaryStage) {
        model = Model.getInstancia();
        inicializarUsuarios();

        MainView mainView = new MainView();
        mainView.init(model, primaryStage); // passa o Stage real
    }

    private void inicializarUsuarios() {
        model.setUsuario("eu", "eu", "eu");
        model.setUsuario("vc", "vc", "vc");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

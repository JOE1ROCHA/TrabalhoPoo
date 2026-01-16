package ufc.br;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println(
                getClass().getResource("/ufc/br/view/main.fxml")
        );

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ufc/br/view/MainView.fxml")
        );

        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Kanban");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

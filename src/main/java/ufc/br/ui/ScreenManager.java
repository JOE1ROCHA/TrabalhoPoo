package ufc.br.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {

    private static ScreenManager instance;
    private Stage stage;

    private ScreenManager() {}

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void init(Stage stage) {
        this.stage = stage;
    }

    public void show(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}

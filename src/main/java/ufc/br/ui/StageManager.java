package ufc.br.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ufc.br.model.Model;

public class StageManager {

    private static StageManager instancia; // Singleton
    private Stage primaryStage;
    private Model model;

    private StageManager() { }

    public static StageManager getInstancia() {
        if (instancia == null) {
            instancia = new StageManager();
        }
        return instancia;
    }

    public void init(Stage stage, Model model) {
        this.primaryStage = stage;
        this.model = model;
    }

    public void switchScene(Scene scene) {
        if(primaryStage != null && scene != null) {
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    /**
     * Fecha o Stage principal (alias de closeApp)
     */
    public void closeStage() {
        closeApp();
    }

    /**
     * Fecha o Stage principal e encerra o programa
     */
    public void closeApp() {
        if(primaryStage != null) {
            primaryStage.close();
        }
    }

    // --------------------------
    // Métodos de conveniência para exibir Views
    // --------------------------
    public void showMainView() {
        ufc.br.view.MainView mainView = new ufc.br.view.MainView();
        mainView.init(model, primaryStage); // <-- agora correto
    }

    public void showLoginUserView() {
        ufc.br.view.LoginUserView loginView = new ufc.br.view.LoginUserView();
        loginView.init(model, primaryStage);
    }

    public void showNewUserView() {
        ufc.br.view.NewUserView newUserView = new ufc.br.view.NewUserView();
        newUserView.init(model, primaryStage);
    }

    public void showUserView() {
        ufc.br.view.UserView userView = new ufc.br.view.UserView();
        userView.init(model, primaryStage);
    }

    public void showTrabalhosView() {
        ufc.br.view.TrabalhosView trabalhosView = new ufc.br.view.TrabalhosView();
        trabalhosView.init(model, primaryStage);
    }

    public void showTarefasView() {
        ufc.br.view.TarefasView tarefasView = new ufc.br.view.TarefasView();
        tarefasView.init(model, primaryStage);
    }

    public void showNewTrabalhoView() {
        ufc.br.view.NewTrabalhoView newTrabalhoView = new ufc.br.view.NewTrabalhoView();
        newTrabalhoView.init(model, primaryStage);
    }

    public void showNewTarefaView() {
        ufc.br.view.NewTarefaView newTarefaView = new ufc.br.view.NewTarefaView();
        newTarefaView.init(model, primaryStage);
    }

}

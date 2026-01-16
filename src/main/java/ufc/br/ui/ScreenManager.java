package ufc.br.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ufc.br.model.Model;

/**
 * ScreenManager gerencia a troca de telas em um único Stage.
 * Todas as views usam este manager para trocar de Scene.
 */
public class ScreenManager {

    private static ScreenManager instancia; // Singleton
    private Stage stage;
    private Model model;

    private ScreenManager() {
        // privado para singleton
    }

    public static ScreenManager getInstancia() {
        if (instancia == null) {
            instancia = new ScreenManager();
        }
        return instancia;
    }

    /**
     * Inicializa o ScreenManager com Stage e Model
     */
    public void init(Stage stage, Model model) {
        this.stage = stage;
        this.model = model;
    }

    /**
     * Troca para a tela principal (MainView)
     */
    public void showMainView() {
        ufc.br.view.MainView mainView = new ufc.br.view.MainView();
        mainView.init(model, stage);
    }

    /**
     * Troca para tela de login
     */
    public void showLoginUserView() {
        ufc.br.view.LoginUserView loginView = new ufc.br.view.LoginUserView();
        loginView.init(model, stage);
    }

    /**
     * Troca para tela de cadastro de usuário
     */
    public void showNewUserView() {
        ufc.br.view.NewUserView newUserView = new ufc.br.view.NewUserView();
        newUserView.init(model, stage);
    }

    /**
     * Troca para tela do usuário logado
     */
    public void showUserView() {
        ufc.br.view.UserView userView = new ufc.br.view.UserView();
        userView.init(model, stage);
    }

    /**
     * Troca para tela de trabalhos
     */
    public void showTrabalhosView() {
        ufc.br.view.TrabalhosView trabalhosView = new ufc.br.view.TrabalhosView();
        trabalhosView.init(model, stage);
    }

    /**
     * Troca para tela de tarefas de um trabalho
     */
    public void showTarefasView() {
        ufc.br.view.TarefasView tarefasView = new ufc.br.view.TarefasView();
        tarefasView.init(model, stage);
    }

    /**
     * Troca para tela de cadastro de trabalho
     */
    public void showNewTrabalhoView() {
        ufc.br.view.NewTrabalhoView newTrabalhoView = new ufc.br.view.NewTrabalhoView();
        newTrabalhoView.init(model, stage);
    }

    /**
     * Troca para tela de cadastro de tarefa
     */
    public void showNewTarefaView() {
        ufc.br.view.NewTarefaView newTarefaView = new ufc.br.view.NewTarefaView();
        newTarefaView.init(model, stage);
    }

    /**
     * Troca a Scene atual
     */
    public void setScene(Scene scene) {
        if(stage != null) {
            stage.setScene(scene);
            stage.show();
        }
    }
}

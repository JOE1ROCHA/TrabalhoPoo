package ufc.br.model;


import java.util.HashMap;
import java.util.ArrayList;

/*
 * Classe Modelo que provê alguns dados e serviços para views e controllers
 */
public class Model {
    /*
     * Dados do sistema
     */
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private Usuario usuarioAutenticado;	// Usuário autenticado pelo sistema
    private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo

    private static Model instanciaUnica; // Instância do padrão Singleton


    /*
     * Construtor privado para implementação do padrão de projeto Singleton
     */
    private Model(){
        super();
    }

    public static Model getInstancia(){
        if (instanciaUnica == null){
            instanciaUnica = new Model();
        }
        return instanciaUnica;
    }

    /*
     * Método utilizado para notificar todos os observadores contidos no ArrayList que o modelo mudou
     */
    public void notifica() {
        for (Observer o : observers) {
            o.update(); // update é a operação definida na interface Observer
        }
    }

    /*
     * Devolve o nome de um usuário do mapeamento
     */
    public String getNomeUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            if (usuario != null){
                return usuario.getNome();
            }
        }
        return "";
    }

    /*
     * Devolve o login do usuário autenticado
     */
    public String getUsuarioLogin() {
        if (usuarioAutenticado != null) {
            return usuarioAutenticado.getLogin();
        }
        return "";
    }

    /*
     * Adiciona um usuário no mapeamento
     */
    public void setUsuario(String nome, String login, String senha) {
        if (nome != null && login != null && senha != null) {
            usuarios.put(login, new Usuario(nome, login, senha));
            notifica();
        }
    }

    /*
     * Serviço para autenticar um usuário
     */
    public boolean autenticarUsuario(String login, String senha) {
        Usuario usuario;
        boolean autenticado = false;
        if (login != null && senha != null) {
            usuario = usuarios.get(login);
            if (usuario != null) {
                if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())){
                    usuarioAutenticado = usuario;
                    autenticado = true;
                }
            }
        }
        notifica();
        return autenticado;
    }

    /*
     * Desloga um usuário do sistema
     */
    public void deslogarUsuario() {
        usuarioAutenticado = null;
        notifica();
    }

    /*
     * Devolve o usuário autenticado. Se não tiver nenhum usuário autenticado ele devolve null
     */
    public String getUsuarioAutenticado() {
        if (usuarioAutenticado != null){
            return usuarioAutenticado.getLogin();
        } else {
            return "";
        }
    }

    /*
     * Registra um observador na lista de observadores
     */
    public void attachObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    /*
     * Exclui um observador da lista de observadores
     */
    public void detachObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    /*
     * Informa o total de usuários cadastrados
     */
    public int getTotalUsuarios() {
        return usuarios.size();
    }
}
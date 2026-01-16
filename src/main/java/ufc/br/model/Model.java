package ufc.br.model;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/*
 * Classe Modelo que provê alguns dados e serviços para views e controllers
 */
public class Model {
    /*
     * Dados do sistema
     */
    private HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private HashMap<String, List<Trabalho>> mapDeTrabalhos = new HashMap<String, List<Trabalho>>();
    private HashMap<String, List<ItensDeTrabalho>> mapDeTarefas = new HashMap<String, List<ItensDeTrabalho>>();
    private Usuario usuarioAutenticado;    // Usuário autenticado pelo sistema
    private Trabalho trabalhoSelecionado;    // Usuário autenticado pelo sistema
    private ItensDeTrabalho tarefaSelecionada;    // Usuário autenticado pelo sistema


    private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo


    private static Model instanciaUnica; // Instância do padrão Singleton

    private int valor = 0;

    public void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
    /*
     * Construtor privado para implementação do padrão de projeto Singleton
     */
    private Model() {
        super();
    }

    public static Model getInstancia() {
        if (instanciaUnica == null) {
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
            if (usuario != null) {
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
                if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
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
        if (usuarioAutenticado != null) {
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

    public Trabalho getTrabalhoSelecionado() {
        return trabalhoSelecionado;
    }

    public void setTrabalhoSelecionado(Trabalho trabalhoSelecionado) {
        this.trabalhoSelecionado = trabalhoSelecionado;
    }

    public List<Trabalho> getListaTrabalhos(String usuario){
        return mapDeTrabalhos.get(usuario);
    }

    public void setTrabalho(String descricao, String autor, String responsavel, String titulo) {
        if (usuarios.containsKey(autor)) {
            if (descricao != null && autor != null && responsavel != null && titulo != null) {
                if (mapDeTrabalhos.containsKey(autor)) {
                    List<Trabalho> listaTrabalhos = mapDeTrabalhos.get(autor);
                    listaTrabalhos.add(new Trabalho(descricao, autor, responsavel, titulo));
                    mapDeTrabalhos.put(autor, listaTrabalhos);
                    notifica();
                } else {
                    List<Trabalho> listaTrabalhos = new ArrayList();
                    listaTrabalhos.add(new Trabalho(descricao, autor, responsavel, titulo));
                    mapDeTrabalhos.put(autor, listaTrabalhos);
                    notifica();

                }
            }
        }
    }

    public void removerTrabalho(String autor, String titulo) {
        List<Trabalho> listaTrabalhos = getListaTrabalhos(autor);

        if (listaTrabalhos != null) {
            for (Trabalho trabalho : listaTrabalhos) {
                if (trabalho.getTitulo().equals(titulo)) {
                    listaTrabalhos.remove(trabalho);
                    System.out.println("\nTRABALHO REMOVIDO!!\n");
                    break;
                }
            }
        }
    }

    public ItensDeTrabalho getTarefaSelecionada() {
        return tarefaSelecionada;
    }

    public void setTarefaSelecionada(ItensDeTrabalho tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

    public List<ItensDeTrabalho> getListaTarefas(String titulotrabalho) {
        return mapDeTarefas.get(titulotrabalho);
    }

    public void setTarefas(String tituloTarefa, String descricao, String responsavel) {
        if (responsavel != null && trabalhoSelecionado != null && descricao != null) {
            if (mapDeTarefas.containsKey(trabalhoSelecionado.getTitulo())) {
                List<ItensDeTrabalho> listaTarefas = mapDeTarefas.get(trabalhoSelecionado.getTitulo());
                listaTarefas.add(new ItensDeTrabalho(tituloTarefa, descricao, responsavel));
                mapDeTarefas.put(trabalhoSelecionado.getTitulo(), listaTarefas);
                notifica();
            } else {
                List<ItensDeTrabalho> listaTarefas = new ArrayList();
                listaTarefas.add(new ItensDeTrabalho(tituloTarefa, descricao, responsavel));
                mapDeTarefas.put(trabalhoSelecionado.getTitulo(), listaTarefas);
                notifica();

            }
        }
    }

    public void removerTarefa(String tituloTrabalho, String titulo) {
        List<ItensDeTrabalho> listaTarefas = getListaTarefas(tituloTrabalho);

        if (listaTarefas != null) {
            for (ItensDeTrabalho tarefa : listaTarefas) {
                if (tarefa.getTitulo().equals(titulo)) {
                    listaTarefas.remove(tarefa);
                    System.out.println("\nTAREFA REMOVIDA!!\n");
                    break;
                }
            }
        }
    }
}
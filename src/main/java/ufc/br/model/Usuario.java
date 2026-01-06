package ufc.br.model;

import java.util.List;

public class Usuario {
    private String nome;
    private String cargo;
    private List<ItensDeTrabalho> listaItensDeTrabalho;
    private List<Trabalho> listaDeTrabalhos;
    private String login;
    private String senha;

    public Usuario(String nome, String login, String senha){
        setNome(nome);
        setLogin(login);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            this.login = login;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha != null) {
            this.senha = senha;
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<ItensDeTrabalho> getListaItensDeTrabalho() {
        return listaItensDeTrabalho;
    }

    public void setListaItensDeTrabalho(List<ItensDeTrabalho> listaItensDeTrabalho) {
        this.listaItensDeTrabalho = listaItensDeTrabalho;
    }

    public List<Trabalho> getListaDeTrabalhos() {
        return listaDeTrabalhos;
    }

    public void setListaDeTrabalhos(List<Trabalho> listaDeTrabalhos) {
        this.listaDeTrabalhos = listaDeTrabalhos;
    }
    public void handleEvent (String event){

    }
    public void addTrabalho(Usuario newTrabalho) {
        if (newTrabalho!= null) {
            listaDeTrabalhos.add(newTrabalho);
        }
    }

    public String toString() {
        return nome + " " + login;
    }
}

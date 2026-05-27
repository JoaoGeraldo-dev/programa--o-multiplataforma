package org.example;

public class Empresa {

    private int id;
    private String nome;
    private int qtdFunc;
    private String local;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdFunc() {
        return qtdFunc;
    }

    public void setQtdFunc(int qtdFunc) {
        this.qtdFunc = qtdFunc;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
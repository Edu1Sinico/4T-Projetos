package com.example;

public class Produto{
    //atributos
    private int id;
    private String nome;
    private int qtde;
    private String categoria;
    private double preco;

    // Construtores
    public Produto(int id, String nome, int qtde, String categoria, double preco) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Produto(){}

    // Getters and Setters;
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
    public int getQtde() {
        return qtde;
    }
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
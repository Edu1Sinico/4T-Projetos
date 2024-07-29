package com.example;

import java.util.ArrayList;
import java.util.List;

public class Inventorio{
    // Atributos
    private List<Produto> list;

    // Construtor
    public Inventorio() {
        list = new ArrayList<>();
    }

    // Métodos
    public void adicionar(Produto produto){
      list.add(produto);
    }

    public void remover(int id){
        list.removeIf(produto -> produto.getId()==id);
    }

    public void atualizar(int id, double preco, int qtde){
        for (Produto produto : list) {
            if (produto.getId() == id){
                produto.setQtde(qtde);
                produto.setPreco(preco);
                break;
            }
        }
    }

    public List<Produto> listar(){
        return new ArrayList<>(list);
    }
    
}
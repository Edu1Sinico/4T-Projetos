package com.example;

import java.util.*;

public class SetExample {
    // O Set não é ordenado, ou seja, se eu tentar adicionar um atributo com nome
    // semelhantes, irá substituir o valor antigo.

    // Atributos
    private Set<String> nomes;

    // Construtor
    public SetExample() {
        nomes = new HashSet<>();
    }

    // Adicionar
    public void addNome(String nome) {
        nomes.add(nome);
    }

    // Listar
    public void listarNomes() {
        System.out.println(nomes);
    }

    // Remover
    public void removerNomes(String nome) {
        try {
            nomes.remove(nome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}

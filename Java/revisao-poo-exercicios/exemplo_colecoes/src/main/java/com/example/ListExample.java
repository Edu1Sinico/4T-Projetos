package com.example;

import java.util.*;

public class ListExample {
    // O List é ordenado, ou seja, possuí índices
    private List<String> nomes;

    public ListExample() {
        nomes = new ArrayList<>();
    }

    // Adicionar
    public void addNome(String nome) {
        nomes.add(nome);
        System.out.println(nomes.lastIndexOf(nome));
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

    // Atualizar / Modificar
    public void modificarNome(String nomeAntigo, String nomeNovo) {
        try {
            int index = nomes.indexOf(nomeAntigo);
            nomes.set(index, nomeNovo);
            System.out.println("Nome Alterado com Sucesso.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

package com.example;

import java.util.*;

public class MapExample {
    // Map<Nome da Chave, Valor respectivo>
    private Map<String, Integer> nomesIdade;

    public MapExample() {
        nomesIdade = new HashMap<>();
    }

    // Adicionar
    public void addNomeIdade(String nome, int idade) {
        nomesIdade.put(nome, idade);
        System.out.println(nomesIdade.get(nome));
    }

    // Listar
    public void listarNomesIdade() {
        System.out.println(nomesIdade);
    }

    // Remover
    public void removerNomeIdade(String nome) {
        nomesIdade.remove(nome);
    }

    // Atualizar / Modificar
    public void modificarNomeIdade(String nome, int novaIdade) {
        nomesIdade.replace(nome, novaIdade);
    }
}

package com.example;

public class Main {
    public static void main(String[] args) {
        ListExample list = new ListExample();
        SetExample set = new SetExample();
        MapExample map = new MapExample();

        // List
        System.out.println("---------------------------------");
        System.out.println("Conteúdo 1 - Listas:");
        System.out.println("\nAdicionar:\n");

        // Adicionar
        list.addNome("Maria");
        list.addNome("João");
        list.addNome("Pedro");

        // Listar
        list.listarNomes();

        System.out.println("\n---------------------------------");
        System.out.println("Atualizar:\n");

        // Modificar
        list.modificarNome("Pedro", "Maria");

        // Listar
        list.listarNomes();

        System.out.println("\n---------------------------------");
        System.out.println("Remover:\n");

        // Remover
        list.removerNomes("Maria");

        // Listar
        list.listarNomes();

        System.out.println("\n---------------------------------");

        // -------------------------------------------------------------------------------------------------
        // Set

        System.out.println("Conteúdo 2 - Set:");
        System.out.println("\nAdicionar:\n");

        // Adicionar
        set.addNome("Maria");
        set.addNome("João");
        set.addNome("Pedro");

        // Listar
        set.listarNomes();

        System.out.println("\n---------------------------------");
        System.out.println("Remover:\n");

        // Remover
        set.removerNomes("Maria");

        // Listar
        set.listarNomes();

        System.out.println("\n---------------------------------\n");
    }
}
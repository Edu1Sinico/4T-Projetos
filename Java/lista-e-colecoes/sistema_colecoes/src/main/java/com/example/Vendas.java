package com.example;

import java.util.*;
import java.util.stream.*;

public class Vendas {
    // Atributos
    private Map<String, List<Produto>> vendasCPF;

    // Construtor
    public Vendas() {
        vendasCPF = new HashMap<>();
    }

    // Métodos:
    // Cadastrar Venda
    public void cadastroVenda(String cpf, Produto produto) {
        // Pega a informação da chave String (CPF) e armazena em uma variável
        for (String cpfCliente : vendasCPF.keySet()) {
            // Verifica se o valor do cpf digitado pelo usuário já está na lista Map
            if (cpfCliente.equals(cpf)) {
                // Copiar a lista de produtos do usuário já cadastrado
                List<Produto> produtosCPF = vendasCPF.get(cpf);
                // Adiciona um novo produto na lista
                produtosCPF.add(produto);
                // Rescreve a lista Map com as novas informações de venda para o usuário
                vendasCPF.put(cpf, produtosCPF);
                // Finaliza a seção
                return;
            }
        }
        // Caso o cpf do cliente não esteja cadastrado, ele faz esse processo:
        // Cria uma nova lista de produtos
        List<Produto> produtosCPFVazio = new ArrayList<>();
        // Adiciona um novo produto na lista
        produtosCPFVazio.add(produto);
        // Rescreve a lista Map com as novas informações de venda para o usuário
        vendasCPF.put(cpf, produtosCPFVazio);
    }

    // Listar Produtos de um CPF:
    public List<Produto> listarProdutos(String cpf) {
        // Armazena as informações em uma lista conforme a chave CPF
        // Caso não for encontrado o cpf, ele cria uma lista vazia;
        List<Produto> listaCPF = vendasCPF.getOrDefault(cpf, Collections.emptyList());
        return listaCPF;
    }

    // Lista com Filtro (Método Stream)
    public List<Produto> listarProdutosFiltro(String cpf, double valorMinimo) {
        List<Produto> listaCPFiltro = vendasCPF.getOrDefault(cpf, Collections.emptyList());
        if (listaCPFiltro.isEmpty()) {
            System.err.println("CPF não encotrado.");
            return null;
        } else {
            List<Produto> resultado = listaCPFiltro.stream()
                    .filter(p -> p.getPreco() >= valorMinimo)
                    .collect(Collectors.toList());
            return resultado;
        }
    }
}

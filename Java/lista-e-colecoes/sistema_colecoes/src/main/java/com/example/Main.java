package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Vendas vendas = new Vendas();
        int operacao;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Gerenciamento de Vendas ---\n\n"
                    + "1 - Cadastrar Venda \n"
                    + "2 - Listar Vendas por CPF\n"
                    + "3 - Listar Vendas por CPF e Valor Mínimo\n"
                    + "4 - Sair\n\n"));
            switch (operacao) {
                case 1:
                    String cpfVenda = JOptionPane.showInputDialog("--- Cadastrar Venda ---\n\n"
                            + "Informe o CPF do cliente:");
                    String nomeProduto = JOptionPane.showInputDialog("--- Cadastrar Venda ---\n\n"
                            + "Informe o nome do produto:");
                    double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("--- Cadastrar Venda ---\n\n"
                            + "Informe o preço do produto:"));
                    Produto produto = new Produto(nomeProduto, precoProduto);
                    vendas.cadastroVenda(cpfVenda, produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    break;

                case 2:
                    String cpfCliente = JOptionPane.showInputDialog("--- Listar Vendas por CPF ---\n\n"
                            + "Informe o CPF do cliente:");
                    System.out.println(vendas.listarProdutos(cpfCliente).toString());
                    break;

                case 3:
                    String cpfCliente2 = JOptionPane.showInputDialog("--- Listar Vendas por CPF e Valor Mínimo ---\n\n"
                            + "Informe o CPF do cliente:");
                    double valorMinimo = Double
                            .parseDouble(JOptionPane.showInputDialog("--- Listar Vendas por CPF e Valor Mínimo ---\n\n"
                                    + "Informe o valor mínimo da lista:"));
                    try {
                        System.out.println(vendas.listarProdutosFiltro(cpfCliente2, valorMinimo).toString());
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o meu programa!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Escolha uma das opções citadas!");
                    break;
            }

        } while (operacao != 4);
    }
}
package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio1 {
    public void exercicio1() {
        String arquivosNotas = "C:\\Users\\DevTarde\\Documents\\Eduardo\\4TProjetos\\IAML-Oracle\\Java\\exercicio_dados_informacoes\\notas.txt";
        String linha;
        int numAlunos = 0;
        int numNotas = 0;
        int totalNotas = 0;
        double somaTotal = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivosNotas))) {

            // Primeiro, contar o número de linhas e o número de notas
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                numAlunos++;
                numNotas = valores.length - 1;
            }

            Double[][] notas = new Double[numAlunos][numNotas];

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");

                // Preencher a Array de notas conforme o app for rodando
                for (int i = 0; i < numAlunos; i++) {
                    for (int j = 1; j <= numNotas; j++) {
                        notas[i][j - 1] = Double.parseDouble(valores[j]);
                    }
                }

                // Calcular o total de notas
                for (int i = 0; i < numNotas; i++) {
                    totalNotas++;
                }

                // Calulcar a soma das notas
                for (int i = 0; i < numAlunos; i++) {
                    for (int j = 0; j < numNotas; j++) {
                        somaTotal += notas[i][j];
                    }
                }
            }

            // Calcular a média total
            double mediaTotal = somaTotal / totalNotas;

            System.out.println("A média total dos alunos é: " + mediaTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
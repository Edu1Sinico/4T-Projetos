package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio1 {
    public void exercicio1() {
        String arquivosNotas = "C:\\Users\\DevTarde\\Documents\\Eduardo\\4TProjetos\\IAML-Oracle\\Java\\exercicio_dados_informacoes\\notas.txt";
        String[] valores;
        String linha;
        int numAlunos = 0;
        int numNotas = 0;
        double somaTotal = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivosNotas))) {
            // Primeiro, contar o número de linhas e o número de notas
            while ((linha = br.readLine()) != null) {
                valores = linha.split(",");
                numAlunos++;
                numNotas = valores.length - 1;
            }

            Double[][] notas = new Double[numAlunos][numNotas];

            int alunoIndex = 0;
            while ((linha = br.readLine()) != null) {
                valores = linha.split(",");
                for (int j = 1; j < valores.length; j++) {
                    notas[alunoIndex][j - 1] = Double.parseDouble(valores[j]);
                    somaTotal += notas[alunoIndex][j - 1];
                }
                alunoIndex++;
            }

            // Calcular a média total
            double mediaTotal = somaTotal / (numAlunos * numNotas);

            System.out.println("A média total dos alunos é: " + mediaTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Exercicio1().exercicio1();
    }
}
package com.example.Exercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Exercicio1LeituraArquivo {
    // Arquivos de entrada e saída
    String inputFile = "alunos_notas.txt";

    // Lista para armazebar is alunos e suas médias
    List<Aluno> alunos = new ArrayList<>();
    double somaTotalNotas = 0;
    int totalAlunos = 0;

    // Método
    public void app() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linha;
            // Primeiro, contar o número de linhas e o número de notas
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if(partes.length < 2)
                {
                    System.out.println("Erro.");
                    continue;
                }
                String nome = partes[0];
                double somaNotas = 0;
                int numeroNotas = 0;
                try {
                    for (int i = 1; i < partes.length; i++){
                        somaNotas += Double.parseDouble(partes[i]);
                        numeroNotas++;
                    }
                } catch (NumberFormatException ex) {
                    somaNotas += 0;
               }
               double media = somaNotas / numeroNotas;
               alunos.add(new Aluno(nome,media));

               somaTotalNotas += media;
               totalAlunos++; //Incrementa o contador de alunos

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Aluno alunoMaiorNota = alunos.get(0);
        Aluno alunoMenorNota = alunos.get(0);

        // Percorre a lista de alunos para encontrar o de maior e menor média;
        for (Aluno aluno : alunos) {
            if(aluno.getMedia() > alunoMaiorNota.getMedia()){
                alunoMaiorNota = aluno; // Atualiza o aluno com maior média
            }
            if (aluno.getMedia() < alunoMenorNota.getMedia()){
                alunoMenorNota = aluno; // Atualiza o aluno com menor média
            }
        }

        double mediaGeralTurma = somaTotalNotas / totalAlunos; // Calcula a média geral 

        // Exibe os resultado no console
        System.out.println("");
        System.out.println("Aluno com a maior nota: " + alunoMaiorNota.getNome() + " - Média: " + alunoMaiorNota.getMedia() + ".");
        System.out.println("Aluno com a menor nota: " + alunoMenorNota.getNome() + " - Média: " + alunoMenorNota.getMedia() + ".");
        System.out.println("Média geral da turma: " + mediaGeralTurma + ".");
        System.out.println("");
    }
}

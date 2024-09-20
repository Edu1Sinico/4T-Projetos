package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Professor;

public class Curso {
    ArrayList<Aluno> listaAluno = new ArrayList<>();
    ArrayList<Professor> listaProfessor = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Métodos
    public void adicionarAluno() {
        System.out.println("\n+-----------------------------------+\n");
        System.out.println("Adicionar um Aluno\n");
        System.out.println("Informe o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("\nInforme o CPF do aluno: ");
        String cpfString = sc.nextLine();
        cpfString = cpfString.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos
        int cpf = Integer.parseInt(cpfString);

        


    }

}

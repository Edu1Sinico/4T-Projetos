package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Professor;

public class CursoController {
    private String curso;
    private ArrayList<Aluno> listaAluno;
    private Professor professor;
    Scanner sc = new Scanner(System.in);
    private int matricula = 0;

    // Métodos
    public CursoController(String curso) {
        this.curso = curso;
        listaAluno = new ArrayList<>();
    }

    public void adicionarAluno() {
        try {
            System.out.println("\n-------------------------------------\n");
            System.out.println("Adicionar um Aluno\n");
            System.out.println("Informe o nome do aluno: ");
            String nome = sc.nextLine();
            System.out.println("\nInforme o CPF do aluno: ");
            String cpfString = sc.nextLine();
            cpfString = cpfString.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos
            int cpf = Integer.parseInt(cpfString);
            matricula += 1;

            Aluno aluno = new Aluno(nome, cpf, matricula);

            listaAluno.add(aluno);

        } catch (NullPointerException ex) {
            throw new NullPointerException("O valor não pode ser vazio! " + ex);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("O valor não pode conter textos! " + ex);
        }
    }

    public void adicionarProf() {
        try {
            System.out.println("\n-------------------------------------\n");
            System.out.println("Adicionar um Professor\n");
            System.out.println("Informe o nome do professor: ");
            String nome = sc.nextLine();
            System.out.println("\nInforme o CPF do professor: ");
            String cpfString = sc.nextLine();
            cpfString = cpfString.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos
            int cpf = Integer.parseInt(cpfString);
            System.out.println("\nInforme o salário do professor: ");
            double salario = Double.parseDouble(sc.nextLine());

            new Professor(nome, cpf, salario);

        } catch (NullPointerException ex) {
            throw new NullPointerException("O valor não pode ser vazio! " + ex);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("O valor não pode conter textos! " + ex);
        }
    }

    // Lançar notas para os alunos
    public void lancarNotas(String nome, double nota) {
        for (Aluno aluno : listaAluno) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                aluno.setNota(nota);
                System.out.println("\nNota inserida com sucesso!");
                return;
            } else {
                System.out.println("\nAluno não encontrado.");
            }
        }
    }

    // Exibir nota finl de todos os alunos
    public void resultadoFinal() {
        for (Aluno aluno : listaAluno) {
            System.out.println(aluno.exibirInformacoes());
            aluno.avaliarDesempenho();
        }
    }
}

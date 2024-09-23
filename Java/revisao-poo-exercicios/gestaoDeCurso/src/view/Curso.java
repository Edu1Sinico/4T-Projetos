package view;

import controller.CursoController;

import java.util.Scanner;

public class Curso {
    CursoController gerenciamento = new CursoController("Matemática");
    Scanner sc = new Scanner(System.in);

    public void menu() {
        int operacao = 0;
        do {
            System.out.println("\n-------------------------------------\n");
            System.out.println("Sistema de Gestão de Cursos\n");

            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Lançar Notas");
            System.out.println("4 - Resultado Final");
            System.out.println("5 - Sair");

            System.out.print("\nOpção: ");
            operacao = Integer.parseInt(sc.nextLine());

            switch (operacao) {
                case 1:
                    gerenciamento.adicionarProf();
                    break;

                case 2:
                    gerenciamento.adicionarAluno();
                    break;
                
                case 3:
                System.out.println("\n+-----------------------------------+\n");
                    System.out.println("Informe o nome do aluno: ");
                    String nome = sc.nextLine();
                    System.out.println("\nInforme a nota do aluno: ");
                    double nota = Double.parseDouble(sc.nextLine());
                    gerenciamento.lancarNotas(nome, nota);

                case 4:
                    gerenciamento.resultadoFinal();
                    break;

                case 5:
                    System.out.println("\nSaindo...\n");
                    break;

                default:
                    System.out.println("\nEscolha uma das opções mencionadas!");
                    break;
            }

        } while (operacao != 5);
    }
}

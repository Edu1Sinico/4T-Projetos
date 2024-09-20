
import java.util.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        GerenciamentoEmprego ex2 = new GerenciamentoEmprego();
        CalculadoraAvancada ex3 = new CalculadoraAvancada();

        int x = 0;
        double n1, n2;

        Scanner sc = new Scanner(System.in);
        // Exercício 1
        // CalcularMedia.calcMedia();

        // ===================================================================================================

        // Exercício 2
        // do {
        // System.out.println("\n-----------------------------------\n");
        // System.out.println("Sistema de Gerenciamento de Funcionários\n");

        // System.out.println("1. Cadastrar Funcionário");
        // System.out.println("2. Remover Funcionário");
        // System.out.println("3. Listar Funcionários");

        // System.out.println("\nEscolha uma das opções:");
        // int opcao = Integer.parseInt(sc.nextLine());

        // switch (opcao) {
        // case 1:
        // ex2.addFuncionario();
        // break;

        // case 2:
        // ex2.removeFuncionario();
        // break;

        // case 3:
        // ex2.getFuncionarios();
        // break;

        // default:
        // System.out.println("\nEscolha uma das opções!");
        // break;
        // }
        // System.out.println("Deseja continuar? " +
        // "\nSim - 1 " +
        // "\nNão - Qualquer outro valor.\n");

        // x = Integer.parseInt(sc.nextLine());
        // } while (x == 1);

        // ===================================================================================================

        // Exercício 3
        // do {
        // System.out.println("\n-----------------------------------\n");
        // System.out.println("Calculadora Avançada\n");

        // try {
        // System.out.println("Digite o primeiro número: ");
        // n1 = Double.parseDouble(sc.nextLine());
        // System.out.println("\nDigite o segundo número: ");
        // n2 = Double.parseDouble(sc.nextLine());
        // } catch (NumberFormatException e) {
        // throw new NumberFormatException(
        // "Por favor, selecione apenas números neste seguinte formato: (1 ou 1.0).");
        // }

        // System.out.println("\n-----------------------------------\n");
        // System.out.println("Opções de Calculo\n");

        // System.out.println("1. Soma");
        // System.out.println("2. Subtração");
        // System.out.println("3. Multiplicação");
        // System.out.println("4. Divisão");
        // System.out.println("5. Raiz Quadrada");

        // System.out.println("\nEscolha uma das opções:");
        // int opcao = Integer.parseInt(sc.nextLine());

        // switch (opcao) {
        // case 1:
        // System.out.println("\nA soma dos valores é: " + ex3.somar(n1, n2));

        // break;

        // case 2:
        // System.out.println("\nA subtração dos valores é: " + ex3.subtracao(n1, n2));
        // break;

        // case 3:
        // System.out.println("\nA multiplicação dos valores é: " +
        // ex3.multiplicacao(n1, n2));
        // break;

        // case 4:
        // System.out.println("\nA divisão dos valores é: " + ex3.divisao(n1, n2));
        // break;

        // case 5:
        // System.out.println("\nA raiz quadrada do primeiro número digitado é: " +
        // ex3.raizQuadrada(n1));
        // break;

        // default:
        // System.out.println("\nEscolha uma das opções!");
        // break;
        // }
        // System.out.println("\nDeseja continuar? " +
        // "\nSim - 1 " +
        // "\nNão - Qualquer outro valor.\n");

        // x = Integer.parseInt(sc.nextLine());
        // } while (x == 1);

        // ===================================================================================================

        // Exercício 4
        new Fatorial().calcularFatorial();

        // ===================================================================================================

        // Exercício 5


        // ===================================================================================================

        // Exercício 6


    }
}

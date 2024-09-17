import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        GerenciamentoEmprego ex2 = new GerenciamentoEmprego();
        int x = 0;
        Scanner sc = new Scanner(System.in);
        // Exercício 1
        // CalcularMedia.calcMedia();

        // Exercício 2
        do {
            System.out.println("\n-----------------------------------\n");
            System.out.println("Sistema de Gerenciamento de Funcionários\n");

            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Listar Funcionários");

            System.out.println("\nEscolha uma das opções:");
            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    ex2.addFuncionario();
                    break;

                case 2:
                    ex2.removeFuncionario();
                    break;

                case 3:
                    ex2.getFuncionarios();
                    break;

                default:
                    System.out.println("Escolha uma das opções!");
                    break;
            }
            System.out.println("\nDeseja continuar? (0 = Sim) - (Qualquer outro valor = Não)");
            x = Integer.parseInt(sc.nextLine());
        } while (x == 0);
    }
}

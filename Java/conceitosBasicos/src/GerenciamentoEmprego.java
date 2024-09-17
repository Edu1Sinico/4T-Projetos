
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoEmprego {
    ArrayList<String[]> listaFuncionarios = new ArrayList<>();
    String[] funcionario = new String[3];
    String[] informacoesFunc = {"Nome", "Idade", "Salário"};
    String nome = "";
    int i = -1, cont = 0;
    Scanner sc = new Scanner(System.in);

    // Adicionar funcionario
    public void addFuncionario() {
        System.out.println("\n-----------------------------------\n");
        System.out.println("Cadastro de Funcionários\n");
        System.out.println("Informe o nome do funcionário: ");
        funcionario[0] = sc.nextLine();
        System.out.println("\nInforme a idade do funcionário: ");
        funcionario[1] = sc.nextLine();
        System.out.println("\nInforme o salário do funcionário: ");
        funcionario[2] = sc.nextLine();

        listaFuncionarios.add(funcionario);
        System.out.println("\n-----------------------------------\n");
    }

    // Remover funcionario
    public void removeFuncionario() {
        System.out.println("\n-----------------------------------\n");
        System.out.println("Remoção de Funcionários\n");
        System.out.println("Informe o nome do funcionário para ser excluido: ");
        nome = sc.nextLine();

        for (String[] funcionarios : listaFuncionarios) {
            for (String funcEspecifico : funcionarios) {
                i++;
                if (funcEspecifico == nome) {
                    listaFuncionarios.remove(i);
                    break;
                }
            }
        }

        nome = "";
        i = -1;
        System.out.println("\n-----------------------------------\n");
    }

    // listar Funcionarios
    public void getFuncionarios() {
        System.out.println("\n-----------------------------------\n");
        for (String[] funcionarios : listaFuncionarios) {
            for (String funcEspecifico : funcionarios) {
                System.out.print(funcEspecifico + " ");
            }
            System.out.println();
        }
        System.out.println("\n-----------------------------------\n");
    }
}

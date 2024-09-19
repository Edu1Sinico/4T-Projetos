
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoEmprego {
    ArrayList<String[]> listaFuncionarios = new ArrayList<>();
    String[] informacoesFunc = { "Nome", "- Idade", "- Salário" };
    String nome = "";
    int i = -1, j = 0;
    Scanner sc = new Scanner(System.in);

    // Adicionar funcionario
    public void addFuncionario() {
        String[] funcionario = new String[3];
        System.out.println("\n-----------------------------------\n");
        System.out.println("Cadastro de Funcionários\n");
        System.out.println("Informe o nome do funcionário: ");
        funcionario[0] = sc.nextLine() + " ";
        System.out.println("\nInforme a idade do funcionário: ");
        funcionario[1] = sc.nextLine() + " ";
        System.out.println("\nInforme o salário do funcionário: ");
        funcionario[2] = sc.nextLine() + " ";

        listaFuncionarios.add(funcionario);
        System.out.println("\n-----------------------------------\n");
    }

    // Remover funcionario
    public void removeFuncionario() {
        boolean funcEncontrado = false;
        System.out.println("\n-----------------------------------\n");
        System.out.println("Remoção de Funcionários\n");
        System.out.println("Informe o nome do funcionário para ser excluido: ");
        nome = sc.nextLine();

        for (String[] funcionarios : listaFuncionarios) {
            i++;
            System.out.println(funcionarios[i % 2]);
            if (funcionarios[i % 2].contains(nome)) {
                listaFuncionarios.remove(i);
                System.out.println("\nFuncionário removido com sucesso!");
                funcEncontrado = true;
                break;
            }
        }

        if (!funcEncontrado) {
            System.out.println("\nO funcionário não foi encontrado.");
        }

        nome = "";
        funcEncontrado = false;
        i = -1;
        System.out.println("\n-----------------------------------\n");

    }

    // listar Funcionarios
    public void getFuncionarios() {
        System.out.println("\n-----------------------------------\n");
        for (String[] funcionarios : listaFuncionarios) {
            for (String funcEspecifico : funcionarios) {
                System.out.print(informacoesFunc[j] + ": " + funcEspecifico.replace(" ", "") + " ");
                j++;
            }
            j = 0;
            System.out.println();
        }
        System.out.println("\n-----------------------------------\n");
    }
}

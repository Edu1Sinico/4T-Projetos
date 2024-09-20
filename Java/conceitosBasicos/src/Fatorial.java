import java.util.Scanner;

public class Fatorial {
    int n1 = 0;

    Scanner sc = new Scanner(System.in);

    // Método fatorial
    public int fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }

    public void calcularFatorial() {
        try {
            System.out.println("\nInforme um valor para ser calculado o seu fatorial: ");
            n1 = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Por favor, informe apenas números inteiros positivos.");
        }
        System.out.println("\nResultado do fatorial de " + n1 + ": " + fatorial(n1));
    }
}

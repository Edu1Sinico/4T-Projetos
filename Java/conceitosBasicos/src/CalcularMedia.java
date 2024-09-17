import java.util.Scanner;

public class CalcularMedia {
    public static void calcMedia() {
        double[] mediaDisc = new double[4];
        double[] notasDisc = new double[8];
        String[] disciplinas = { "Matemática", "Língua Portuguesa", "Ciências", "História" };
        double mediaFinal = 0, resultado = 0;
        int j = 0,z = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < notasDisc.length; i++) {

            if (i % 2 == 0) {
                System.out.println("\n-----------------------------------\n");
                System.out.println("Disciplina " + (j + 1) + " - " + disciplinas[j] + ":");
                System.out.println("\nPor favor, informe sua primeira nota nota: ");
            } else {
                System.out.println("\nPor favor, informe sua segunda nota nota: ");
                j++;
            }

            notasDisc[i] = Double.parseDouble(sc.nextLine());

        }

        System.out.println("\n-----------------------------------\n");
        j = 0;

        for (int i = 0; i < 7; i++) {

            if (i % 2 == 0) {
                mediaDisc[j] = (notasDisc[i] + notasDisc[i + 1]) / 2;
                System.out.print(
                        "Média da Disciplina de " + disciplinas[j] + ": " + mediaDisc[j] + " - ");
                // System.out.println(mediaDisc[i] >= 7 ? "Aprovado" : "Reprovado");
                if (mediaDisc[j] >= 7) {
                    System.out.println("Aprovado.");
                } else if (mediaDisc[j] >= 5 && mediaDisc[j] <= 6.9) {
                    System.out.println("Recuperação.");
                } else {
                    System.out.println("Reprovado.");
                }

            } else {
                j++;
            }
        }

        System.out.println("\n-----------------------------------\n");

    }
}

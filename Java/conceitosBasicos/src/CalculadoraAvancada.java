public class CalculadoraAvancada {
    // Atributos

    // Métodos
    // Soma
    public double somar(double n1, double n2) {
        return n1 + n2;
    }

    // Subtração
    public double subtracao(double n1, double n2) {
        return n1 - n2;
    }

    // Multiplicação
    public double multiplicacao(double n1, double n2) {
        return n1 * n2;
    }

    // Divisão
    public double divisao(double n1, double n2) {
        try {
            return n1 / n2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Não existe divisão por zero.");
        }
    }

    // Raiz Quadrada
    public double raizQuadrada(double n1) {
        try {
            return Math.sqrt(n1);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Não existe raiz quadrada de número negativo.");
        }
    }
}

package model;

public class Professor extends Pessoa {
    private double salario;

    public Professor() {
    };

    public Professor(String nome, int cpf, double salario) {
        super();
        this.salario = salario;
        System.out.println("\nProfessor cadastrado com sucesso!");
    }

    @Override
    public String exibirInformacoes() {
        super.exibirInformacoes();
        return "\nSalário: " + salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}

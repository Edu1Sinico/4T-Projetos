package model;

public class Professor extends Pessoa {
    private double salario;

    @Override
    public void exibirInformacoes() {
        System.out.println(
                "Nome do Professor: " + getNome()
                        + "\n CPF: " + getCpf()
                        + "\n Número da matrícula: " + salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}

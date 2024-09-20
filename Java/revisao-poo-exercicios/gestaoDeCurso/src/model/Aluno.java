package model;

public class Aluno extends Pessoa {
    private int matricula;

    @Override
    public void exibirInformacoes() {
        System.out.println(
                "Nome: " + getNome()
                        + "\n CPF: " + getCpf()
                        + "\n Número da matrícula: " + matricula);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}

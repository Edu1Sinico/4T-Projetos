package model;

public class Aluno extends Pessoa implements Avaliavel{
    private int matricula;
    private double nota;

    public Aluno() {
    };

    public Aluno(String nome, int cpf, int matricula) {
        super();
        this.matricula = matricula;
        this.nota = 0.0;
    }

    @Override
    public String exibirInformacoes() {
        super.exibirInformacoes();
        return "\nMatrícula: " + matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public void avaliarDesempenho() {
        if (nota >= 7){
            System.out.println("\nAluno Aprovado.");
        } else if (nota >= 5 && nota < 7){
            System.out.println("\nAluno de Recuperação.");
        }
        else{
            System.out.println("\nAluno Reprovado.");
        }
    }

}

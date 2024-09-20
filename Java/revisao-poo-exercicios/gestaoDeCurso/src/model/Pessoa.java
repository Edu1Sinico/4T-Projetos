package model;

public abstract class Pessoa {
    private String nome;
    private int cpf;

    public void exibirInformacoes() {
        System.out.println(
                "Nome: " + nome
                        + "\n CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

}

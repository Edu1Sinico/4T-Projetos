package model;

public class Livro extends Produto implements Transportavel {

    // Construtor
    public Livro(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcFrete() {
        return 2;
    }

    @Override
    public double calcPeso() {
        return 0.5;
    }

}

package model;

public class Roupa extends Produto implements Transportavel {
    // Atributos
    private double volume;

    // Construtor
    public Roupa(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    // Métodos
    @Override
    public double calcFrete() {
        double valorFrete = calcPeso()*5;
        return valorFrete;
    }

    @Override
    public double calcPeso() {
        double peso = volume * 10;
        return peso;
    }
}

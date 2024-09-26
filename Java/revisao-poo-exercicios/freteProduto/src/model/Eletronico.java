package model;

public class Eletronico extends Produto implements Transportavel{
    // Atributo
    private double volume;

    // Construtor
    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    // Método da classe Produto
    @Override
    public double calcPeso() {
        double peso = volume * 150;
        return peso;
    }

    // Método da interface Transportavel
    @Override
    public double calcFrete(){
        double valorFrete = calcPeso()*1;
        return valorFrete;
    }

}

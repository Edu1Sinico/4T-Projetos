package com.example;

import java.lang.Math;

public class Calculadora {

    public int soma(int a, int b) {
        return a + b;
    }

    public int subtracao(int a, int b) {
        return a - b;
    }

    public int multiplicacao(int a, int b) {
        return a * b;
    }

    public double divisao(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida!");
        }
        return a / b;
    }

    public int potencia(int a, int b){
        return (int) Math.pow(a, b);
    }

    public double raiz(double a, double b){
        if (b <= 0){
            throw new IllegalArgumentException("A raiz não pode ser menor ou igual à zero");
        }
        if (a < 0 && b%2 == 0){
            throw new ArithmeticException("Valor negativo não é permitido para raizes pares!");
        }
        double raiz = 1/b;
        double resultado = Math.pow(a,raiz);
        return resultado;
    }
}

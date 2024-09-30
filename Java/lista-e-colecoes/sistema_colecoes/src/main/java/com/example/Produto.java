package com.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    // Atributos
    private String nome;
    private double preco;

    // toString
    @Override
    public String toString() {
        return "Nome: " + nome + " | " + "Preço: " + preco;
    }
}

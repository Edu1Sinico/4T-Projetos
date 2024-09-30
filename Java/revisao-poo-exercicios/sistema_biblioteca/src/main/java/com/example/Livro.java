package com.example;

import java.util.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Livro extends ItemBiblioteca implements Reservavel {

    public Livro(String nome, String titulo, int emprestimo) {
        super(nome, titulo);
    }

    // Livro pode ser emprestado por 14 dias
    // Cadastrar o usuário conforme realizar o emprestimo
    @Override
    public int emprestar() {
        return 14;
    }

    @Override
    public void reservar() {
        
    }
}

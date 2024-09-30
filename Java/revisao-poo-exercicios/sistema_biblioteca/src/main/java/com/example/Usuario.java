package com.example;

import java.util.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    private String nome;
    private String cpf;

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void devolverLivro() {
        
    }
}

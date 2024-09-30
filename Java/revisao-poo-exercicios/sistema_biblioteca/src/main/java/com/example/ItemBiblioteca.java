package com.example;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public abstract class ItemBiblioteca {
    private String titulo;
    private String autor;

    public ItemBiblioteca(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract int emprestar();

}

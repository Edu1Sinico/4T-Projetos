package com.example;

public class MaterialEletronico extends ItemBiblioteca {

    // Materiais eletrônicos são emprestador por apenas 7 dias
    @Override
    public int emprestar() {
        return 7;
    }
}
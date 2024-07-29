package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class InventorioTeste {
    private Inventorio inv;
    private List<Produto> lista;

    @Before
    public void setup() {
        inv = new Inventorio();
    }

    @Test
    public void testeAdicionar(){
        Produto produto = new Produto(1,"Leite Ninho",50,"Alimento",36.99);
        inv.adicionar(produto);
        lista = inv.listar();
        assertEquals(1,lista.size());
    }

    @Test
    public void testeRemover(){
        testeAdicionar();
        inv.remover(1);
        lista = inv.listar();
        assertEquals(0,lista.size());
    }

    @Test
    public void testeAtualizar(){
        Produto produto = new Produto();
        testeAdicionar();
        inv.atualizar(1, 21.99, 100);
        Produto produtoAtualizado = lista.get(0);
        assertEquals(21.99,produtoAtualizado.getPreco(), 0);
        assertEquals(100,produtoAtualizado.getQtde());
    }
}

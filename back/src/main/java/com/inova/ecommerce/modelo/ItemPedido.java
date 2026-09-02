package com.inova.ecommerce.modelo;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private double preco;

    public ItemPedido(Produto produto, int quantidade, double preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public double calcularSubtotal() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - " + quantidade + " x R$ " + preco;
    }
}
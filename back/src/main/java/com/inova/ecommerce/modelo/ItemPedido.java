package com.inova.ecommerce.modelo;

import java.math.BigDecimal;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private BigDecimal preco;

    public ItemPedido(Produto produto, int quantidade, BigDecimal preco) {
        setProduto(produto);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    public ItemPedido(Produto produto, int quantidade, String preco) {
        this(produto, quantidade, new BigDecimal(preco));
    }

    public Produto getProduto() {
        return produto;
    }

    private void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto é obrigatório no item do pedido");
        }
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero: " + quantidade);
        }
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço do item não pode ser negativo");
        }
        this.preco = preco;
    }

    public BigDecimal calcularSubtotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
}
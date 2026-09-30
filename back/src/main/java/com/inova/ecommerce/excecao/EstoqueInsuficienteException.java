package com.inova.ecommerce.excecao;

import com.inova.ecommerce.modelo.Produto;

public class EstoqueInsuficienteException extends ECommerceException {

    private final Produto produto;
    private final int quantidadeSolicitada;

    public EstoqueInsuficienteException(
            Produto produto,
            int quantidadeSolicitada) {

        super(
            "Estoque insuficiente para o produto "
            + produto.getNome()
            + ". Disponível: "
            + produto.getQuantidadeEmEstoque()
            + ", solicitado: "
            + quantidadeSolicitada
        );

        this.produto = produto;
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }
}

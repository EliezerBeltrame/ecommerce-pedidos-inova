package com.inova.ecommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemPedidoTest {

    @Test
    @DisplayName("Deve calcular o subtotal de um item")
    void deveCalcularSubtotal() {

        Produto produto = new Produto(
            "Mouse",
            "Mouse sem fio",
            new BigDecimal("100.00"),
            10
        );

        ItemPedido item = new ItemPedido(
            produto,
            1,
            produto.getPreco()
        );

        BigDecimal subtotalEsperado = new BigDecimal("100.00");

        assertEquals(
            0,
            item.calcularSubtotal().compareTo(subtotalEsperado)
        );
    }

    @Test
    @DisplayName("Deve calcular o subtotal com quantidade maior que um")
    void deveCalcularSubtotalComQuantidadeMaiorQueUm() {

        Produto produto = new Produto(
            "Teclado",
            "Teclado mecânico",
            new BigDecimal("200.00"),
            10
        );

        ItemPedido item = new ItemPedido(
            produto,
            3,
            produto.getPreco()
        );

        BigDecimal subtotalEsperado = new BigDecimal("600.00");

        assertEquals(
            0,
            item.calcularSubtotal().compareTo(subtotalEsperado)
        );
    }
}
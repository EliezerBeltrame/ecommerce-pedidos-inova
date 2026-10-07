package com.inova.ecommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.inova.ecommerce.modelo.pagamento.Pix;

class PedidoTest {

    private Cliente cliente;
    private Pedido pedido;

    @BeforeEach
    void prepararCenario() {
        cliente = new Cliente(
            "Joao Silva",
            "123.456.789-00",
            "joao@email.com",
            "16999999999",
            "Rua A"
        );

        pedido = new Pedido("PED-001", cliente);
    }

    @Test
    @DisplayName("Deve calcular o total de um pedido com um item")
    void deveCalcularTotalComUmItem() throws Exception {

        Produto produto = new Produto(
            "Notebook",
            "Notebook",
            new BigDecimal("3000.00"),
            5
        );

        pedido.adicionarItem(produto, 1);

        BigDecimal totalEsperado = new BigDecimal("3000.00");

        assertEquals(
            0,
            pedido.calcularValorTotal().compareTo(totalEsperado)
        );
    }

    @Test
    @DisplayName("Deve calcular o total de um pedido com varios itens")
    void deveCalcularTotalComVariosItens() throws Exception {

        Produto notebook = new Produto(
            "Notebook",
            "Notebook",
            new BigDecimal("3000.00"),
            5
        );

        Produto mouse = new Produto(
            "Mouse",
            "Mouse sem fio",
            new BigDecimal("100.00"),
            10
        );

        pedido.adicionarItem(notebook, 2);
        pedido.adicionarItem(mouse, 1);

        BigDecimal totalEsperado = new BigDecimal("6100.00");

        assertEquals(
            0,
            pedido.calcularValorTotal().compareTo(totalEsperado)
        );
    }

    @Test
    @DisplayName("Deve ficar PAGO após pagamento aprovado")
    void deveFicarPagoAposPagamentoAprovado() throws Exception {

        Produto produto = new Produto(
            "Notebook",
            "Notebook",
            new BigDecimal("3000.00"),
            5
        );

        pedido.adicionarItem(produto, 1);

        Pix pix = new Pix("pix@email.com");

        pedido.pagar(pix);

        assertEquals(
            SituacaoDoPedido.PAGO,
            pedido.getSituacao()
        );
    }
}
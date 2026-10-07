package com.inova.ecommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.inova.ecommerce.modelo.pagamento.CartaoCredito;
import com.inova.ecommerce.modelo.pagamento.Dinheiro;
import com.inova.ecommerce.modelo.pagamento.Pix;
import com.inova.ecommerce.modelo.pagamento.ProcessadorPagamento;

class PagamentoPolimorficoTest {

    @Test
    @DisplayName("Deve processar diferentes formas de pagamento")
    void deveProcessarDiferentesFormasDePagamento() throws Exception {

        Cliente cliente = new Cliente(
            "Joao Silva",
            "123.456.789-00",
            "joao@email.com",
            "16999999999",
            "Rua A"
        );

        Produto produto = new Produto(
            "Mouse",
            "Mouse sem fio",
            new BigDecimal("100.00"),
            10
        );

        List<ProcessadorPagamento> pagamentos = List.of(
            new Pix("pix@email.com"),
            new CartaoCredito(
                new BigDecimal("100.00"),
                "**** 1234",
                1
            ),
            new Dinheiro(new BigDecimal("100.00"))
        );

        for (ProcessadorPagamento pagamento : pagamentos) {

            Pedido pedido = new Pedido(
                "PED-001",
                cliente
            );

            pedido.adicionarItem(produto, 1);

            boolean resultado = pedido.pagar(pagamento);

            assertTrue(resultado);
            assertTrue(
                pedido.getSituacao() == SituacaoDoPedido.PAGO
            );
        }
    }
}
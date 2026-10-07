package com.inova.ecommerce.modelo.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DinheiroTest {

    @Test
    @DisplayName("Deve criar pagamento em dinheiro corretamente")
    void deveCriarDinheiroCorretamente() {

        Dinheiro dinheiro = new Dinheiro(
            new BigDecimal("200.00")
        );

        assertEquals(
            new BigDecimal("200.00"),
            dinheiro.getValorRecebido()
        );
    }

    @Test
    @DisplayName("Deve aprovar pagamento quando o valor recebido é suficiente")
    void deveAprovarPagamentoQuandoValorESuficiente() {

        Dinheiro dinheiro = new Dinheiro(
            new BigDecimal("200.00")
        );

        boolean resultado = dinheiro.processar(
            new BigDecimal("150.00")
        );

        assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar comprovante do pagamento")
    void deveRetornarComprovante() {

        Dinheiro dinheiro = new Dinheiro(
            new BigDecimal("200.00")
        );

        String comprovante = dinheiro.getComprovante();

        assertNotNull(comprovante);
    }
}
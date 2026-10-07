package com.inova.ecommerce.modelo.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CartaoCreditoTest {

    @Test
    @DisplayName("Deve criar cartão de crédito corretamente")
    void deveCriarCartaoCorretamente() {

        CartaoCredito cartao = new CartaoCredito(
            new BigDecimal("1000.00"),
            "**** 1234",
            3
        );

        assertEquals("**** 1234", cartao.getCartao());
        assertEquals(3, cartao.getParcelas());
        assertEquals(
            new BigDecimal("1000.00"),
            cartao.getValor()
        );
    }

    @Test
    @DisplayName("Deve aprovar pagamento dentro do limite")
    void deveAprovarPagamentoDentroDoLimite() {

        CartaoCredito cartao = new CartaoCredito(
            new BigDecimal("1000.00"),
            "**** 1234",
            3
        );

        boolean resultado = cartao.processar(
            new BigDecimal("500.00")
        );

        assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve recusar pagamento acima do limite")
    void deveRecusarPagamentoAcimaDoLimite() {

        CartaoCredito cartao = new CartaoCredito(
            new BigDecimal("1000.00"),
            "**** 1234",
            3
        );

        boolean resultado = cartao.processar(
            new BigDecimal("1500.00")
        );

        assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar comprovante do cartão")
    void deveRetornarComprovante() {

        CartaoCredito cartao = new CartaoCredito(
            new BigDecimal("1000.00"),
            "**** 1234",
            3
        );

        String comprovante = cartao.getComprovante();

        assertNotNull(comprovante);
    }

    @Test
    @DisplayName("Não deve aceitar valor nulo")
    void naoDeveAceitarValorNulo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                null,
                "**** 1234",
                3
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar valor zero")
    void naoDeveAceitarValorZero() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                BigDecimal.ZERO,
                "**** 1234",
                3
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar cartão vazio")
    void naoDeveAceitarCartaoVazio() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                new BigDecimal("1000.00"),
                "",
                3
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar cartão nulo")
    void naoDeveAceitarCartaoNulo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                new BigDecimal("1000.00"),
                null,
                3
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar parcelas zero")
    void naoDeveAceitarParcelasZero() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                new BigDecimal("1000.00"),
                "**** 1234",
                0
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar parcelas negativas")
    void naoDeveAceitarParcelasNegativas() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                new BigDecimal("1000.00"),
                "**** 1234",
                -1
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar mais de 12 parcelas")
    void naoDeveAceitarMaisDe12Parcelas() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new CartaoCredito(
                new BigDecimal("1000.00"),
                "**** 1234",
                13
            )
        );
    }
}
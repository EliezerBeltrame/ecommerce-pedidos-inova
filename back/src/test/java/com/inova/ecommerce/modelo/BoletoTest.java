package com.inova.ecommerce.modelo.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoletoTest {

    @Test
    @DisplayName("Deve criar boleto corretamente")
    void deveCriarBoletoCorretamente() {

        BigDecimal valor = new BigDecimal("100.00");
        LocalDate vencimento = LocalDate.now().plusDays(5);

        Boleto boleto = new Boleto(valor, vencimento);

        assertEquals(valor, boleto.getValor());
        assertEquals(vencimento, boleto.getVencimento());
    }

    @Test
    @DisplayName("Deve retornar comprovante do boleto")
    void deveRetornarComprovante() {

        Boleto boleto = new Boleto(
            new BigDecimal("100.00"),
            LocalDate.now().plusDays(5)
        );

        String comprovante = boleto.getComprovante();

        assertNotNull(comprovante);
    }

    @Test
    @DisplayName("Boleto deve aguardar compensação")
    void deveAguardarCompensacao() {

        Boleto boleto = new Boleto(
            new BigDecimal("100.00"),
            LocalDate.now().plusDays(5)
        );

        boolean resultado = boleto.processar(
            new BigDecimal("100.00")
        );

        assertFalse(resultado);
    }

    @Test
    @DisplayName("Não deve aceitar valor nulo")
    void naoDeveAceitarValorNulo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Boleto(
                null,
                LocalDate.now().plusDays(5)
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar valor igual a zero")
    void naoDeveAceitarValorZero() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Boleto(
                new BigDecimal("0.00"),
                LocalDate.now().plusDays(5)
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar valor negativo")
    void naoDeveAceitarValorNegativo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Boleto(
                new BigDecimal("-10.00"),
                LocalDate.now().plusDays(5)
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar vencimento nulo")
    void naoDeveAceitarVencimentoNulo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Boleto(
                new BigDecimal("100.00"),
                null
            )
        );
    }

    @Test
    @DisplayName("Não deve aceitar vencimento no passado")
    void naoDeveAceitarVencimentoNoPassado() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Boleto(
                new BigDecimal("100.00"),
                LocalDate.now().minusDays(1)
            )
        );
    }
}
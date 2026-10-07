package com.inova.ecommerce.modelo.pagamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PixTest {

    @Test
    @DisplayName("Deve criar Pix corretamente")
    void deveCriarPixCorretamente() {

        Pix pix = new Pix("pix@email.com");

        assertEquals(
            "Pix - chave pix@email.com",
            pix.getDescricao()
        );
    }

    @Test
    @DisplayName("Deve aprovar pagamento via Pix")
    void deveAprovarPagamentoViaPix() {

        Pix pix = new Pix("pix@email.com");

        boolean resultado = pix.processar(
            new BigDecimal("100.00")
        );

        assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar comprovante do Pix")
    void deveRetornarComprovante() {

        Pix pix = new Pix("pix@email.com");

        String comprovante = pix.getComprovante();

        assertNotNull(comprovante);
    }
}
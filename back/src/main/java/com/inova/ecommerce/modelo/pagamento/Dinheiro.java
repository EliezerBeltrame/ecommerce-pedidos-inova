package com.inova.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Dinheiro implements ProcessadorPagamento {

    private final BigDecimal valorRecebido;

    public Dinheiro(BigDecimal valorRecebido) {
        if (valorRecebido == null || valorRecebido.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                "Valor recebido não pode ser negativo"
            );
        }

        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean processar(BigDecimal valor) {
        return valorRecebido.compareTo(valor) >= 0;
    }

    @Override
    public String getComprovante() {
        return "RECIBO-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Dinheiro";
    }

    public BigDecimal getValorRecebido() {
        return valorRecebido;
    }
}
package com.inova.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class Pix extends FormaPagamento implements ProcessadorPagamento {

    private final String chave;

    public Pix(String chave) {
        if (chave == null || chave.isBlank()) {
            throw new IllegalArgumentException("Chave Pix é obrigatória");
        }

        this.chave = chave;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via Pix.");
    }

    @Override
    public boolean processar(BigDecimal valor) {
        System.out.println("Enviando cobrança Pix para a chave " + chave);
        return true;
    }

    @Override
    public String getComprovante() {
        return "PIX-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Pix - chave " + chave;
    }
}
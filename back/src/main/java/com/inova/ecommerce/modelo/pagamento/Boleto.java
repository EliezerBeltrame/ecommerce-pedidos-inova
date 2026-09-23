package com.inova.ecommerce.modelo.pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto extends FormaPagamento implements ProcessadorPagamento {

    private final BigDecimal valor;
    private final LocalDate vencimento;

    public Boleto(BigDecimal valor, LocalDate vencimento) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do boleto deve ser maior que zero");
        }

        if (vencimento == null) {
            throw new IllegalArgumentException("Vencimento é obrigatório");
        }

        if (vencimento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Vencimento não pode estar no passado");
        }

        this.valor = valor;
        this.vencimento = vencimento;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Boleto de R$ " + valor + " gerado.");
    }

    @Override
    public boolean processar(BigDecimal valor) {
        System.out.println("Boleto aguardando compensação.");
        return false;
    }

    @Override
    public String getComprovante() {
        return "BOLETO-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Boleto - vencimento: " + vencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }
}
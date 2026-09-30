package com.inova.ecommerce.modelo.pagamento;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento implements ProcessadorPagamento {

    private final BigDecimal valor;
    private final String cartao;
    private final int parcelas;

    public CartaoCredito(BigDecimal valor, String cartao, int parcelas) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                "Valor deve ser maior que zero"
            );
        }

        if (cartao == null || cartao.isBlank()) {
            throw new IllegalArgumentException(
                "Cartão é obrigatório"
            );
        }

        if (parcelas <= 0) {
            throw new IllegalArgumentException(
                "Parcelas devem ser maiores que zero"
            );
        }

        if (parcelas > 12) {
            throw new IllegalArgumentException(
                "Cartão não permite mais de 12 parcelas"
            );
        }

        this.valor = valor;
        this.cartao = cartao;
        this.parcelas = parcelas;
    }

    @Override
    public void pagar(double valor) {
        System.out.println(
            "Pagamento de R$ " + valor +
            " realizado no cartão de crédito."
        );
    }

  @Override
public boolean processar(BigDecimal valor) {

    System.out.println(
        "Autorizando cartão " + cartao +
        " em " + parcelas + " parcelas."
    );

    return valor.compareTo(this.valor) <= 0;
}

    @Override
    public String getComprovante() {
        return "CARTAO-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Cartão de crédito - " +
               cartao +
               " - " +
               parcelas +
               "x";
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCartao() {
        return cartao;
    }

    public int getParcelas() {
        return parcelas;
    }
}
package com.inova.ecommerce.modelo.pagamento;

public class CartaoCredito implements FormaPagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via cartão de crédito.");
    }
}
package com.inova.ecommerce.modelo.pagamento;

public class Pix extends FormaPagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via Pix.");
    }
}
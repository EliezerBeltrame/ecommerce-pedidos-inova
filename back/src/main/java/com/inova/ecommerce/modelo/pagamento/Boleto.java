package com.inova.ecommerce.modelo.pagamento;

public class Boleto extends FormaPagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Boleto de R$ " + valor + " gerado.");
    }
}
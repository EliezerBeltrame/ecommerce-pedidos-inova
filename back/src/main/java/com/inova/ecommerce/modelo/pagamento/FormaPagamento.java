package com.inova.ecommerce.modelo.pagamento;

public abstract class FormaPagamento {

    public String getResumo() {
        return getClass().getSimpleName();
    }
}
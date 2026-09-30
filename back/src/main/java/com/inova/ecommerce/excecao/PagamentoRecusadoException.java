package com.inova.ecommerce.excecao;

public class PagamentoRecusadoException extends ECommerceException {

    private final String motivo;

    public PagamentoRecusadoException(String motivo) {
        super("Pagamento recusado: " + motivo);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }
}

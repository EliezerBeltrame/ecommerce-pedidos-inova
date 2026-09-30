package com.inova.ecommerce.excecao;

public class ClienteNaoEncontradoException extends ECommerceException {

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
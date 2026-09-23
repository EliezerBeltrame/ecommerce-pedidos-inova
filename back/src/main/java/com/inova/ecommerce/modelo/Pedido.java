package com.inova.ecommerce.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inova.ecommerce.modelo.pagamento.FormaPagamento;
import com.inova.ecommerce.modelo.pagamento.ProcessadorPagamento;

public class Pedido {

    private String numero;
    private Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();
    private FormaPagamento formaPagamento;

    private SituacaoDoPedido situacao = SituacaoDoPedido.ABERTO;
    private String comprovante;

    public Pedido(String numero, Cliente cliente) {
        setNumero(numero);
        setCliente(cliente);
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException(
                "Número do pedido é obrigatório"
            );
        }

        this.numero = numero.trim();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException(
                "Cliente é obrigatório no pedido"
            );
        }

        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public SituacaoDoPedido getSituacao() {
        return situacao;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void adicionarItem(Produto produto, int quantidade) {

        if (produto == null) {
            throw new IllegalArgumentException(
                "Produto é obrigatório"
            );
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException(
                "Quantidade deve ser maior que zero"
            );
        }

        if (quantidade > produto.getQuantidadeEmEstoque()) {
            throw new IllegalStateException(
                "Estoque insuficiente: " + produto.getNome()
            );
        }

        itens.add(
            new ItemPedido(
                produto,
                quantidade,
                produto.getPreco()
            )
        );
    }

    public void adicionarItem(Produto produto) {
        adicionarItem(produto, 1);
    }

    public boolean pagar(ProcessadorPagamento processador) {

        if (processador == null) {
            throw new IllegalArgumentException(
                "Forma de pagamento é obrigatória"
            );
        }

        if (itens.isEmpty()) {
            throw new IllegalStateException(
                "Pedido sem itens não pode ser pago"
            );
        }

        boolean aprovado = processador.processar(
            calcularValorTotal()
        );

        if (aprovado) {
            this.situacao = SituacaoDoPedido.PAGO;
            this.comprovante = processador.getComprovante();
        }

        return aprovado;
    }

    public BigDecimal calcularValorTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
        }

        return total;
    }
}
package com.inova.ecommerce.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String numero;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total = total + item.calcularSubtotal();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Pedido " + numero +
                " - Cliente: " + cliente.getNome() +
                " - Total: R$ " + calcularValorTotal();
    }
}
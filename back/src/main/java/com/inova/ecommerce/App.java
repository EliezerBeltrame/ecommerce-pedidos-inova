package com.inova.ecommerce;

import com.inova.ecommerce.modelo.Cliente;
import com.inova.ecommerce.modelo.Pedido;
import com.inova.ecommerce.modelo.Produto;

public class App {

    public static void main(String[] args) {

        Produto teclado = new Produto(
                "TEC-001",
                "Teclatek",
                "Teclado da bolivia",
                2000.00,
                10
        );

        Produto monitor = new Produto(
                "MON-002",
                "Monitek",
                "Monitor 30pol",
                2000.00,
                10
        );

        Cliente cliente = new Cliente(
                "Joao Silva",
                "123.456.789-00",
                "joao@email.com",
                "(16) 99999-9999",
                "Rua das Flores, 100"
        );

        Pedido pedido = new Pedido(
                "PED-001",
                cliente
        );

        pedido.adicionarItem(teclado, 2);
        pedido.adicionarItem(monitor, 1);

        System.out.println("=== PEDIDO ===");
        System.out.println("Cliente: " + cliente.getIdentificacao());

        System.out.println("\nItens:");

        pedido.getItens().forEach(item -> {
            System.out.println("Produto: " + item.getProduto().getNome());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Preço: R$ " + item.getPreco());
            System.out.println("Subtotal: R$ " + item.calcularSubtotal());
            System.out.println();
        });

        System.out.println("Total do pedido: R$ " + pedido.calcularValorTotal());
    }
}
```java
package com.inova.ecommerce;

import com.inova.ecommerce.modelo.Cliente;
import com.inova.ecommerce.modelo.ItemPedido;
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

        ItemPedido itemTeclado = new ItemPedido(
                teclado,
                2,
                teclado.getPreco()
        );

        ItemPedido itemMonitor = new ItemPedido(
                monitor,
                1,
                monitor.getPreco()
        );

        Pedido pedido = new Pedido(
                "PED-001",
                cliente
        );

        pedido.adicionarItem(itemTeclado);
        pedido.adicionarItem(itemMonitor);

        System.out.println("=== PEDIDO ===");
        System.out.println("Cliente: " + cliente.getIdentificacao());

        System.out.println("\nItens:");
        System.out.println(itemTeclado);
        System.out.println("Subtotal: R$ " + itemTeclado.calcularSubtotal());

        System.out.println(itemMonitor);
        System.out.println("Subtotal: R$ " + itemMonitor.calcularSubtotal());

        System.out.println("\nTotal do pedido: R$ " + pedido.calcularValorTotal());
    }
}
```

package com.inova.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.inova.ecommerce.modelo.Cliente;
import com.inova.ecommerce.modelo.Pedido;
import com.inova.ecommerce.modelo.Produto;
import com.inova.ecommerce.modelo.pagamento.Boleto;
import com.inova.ecommerce.modelo.pagamento.CartaoCredito;
import com.inova.ecommerce.modelo.pagamento.Dinheiro;
import com.inova.ecommerce.modelo.pagamento.Pix;

public class App {

    public static void main(String[] args) {

        Produto teclado = new Produto(
                "TEC-001",
                "Teclatek",
                new BigDecimal("2000.00"),
                10
        );

        Produto monitor = new Produto(
                "MON-002",
                "Monitek",
                new BigDecimal("2000.00"),
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

        System.out.println(
                "Total do pedido: R$ " + pedido.calcularValorTotal()
        );

        System.out.println("\n=== PAGAMENTO ===");

        // Pix
        Pix pix = new Pix("pix@email.com");

        boolean pagoPix = pedido.pagar(pix);

        System.out.println("Pagamento aprovado: " + pagoPix);
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Comprovante: " + pedido.getComprovante());

        // Cartão de crédito
        CartaoCredito cartao = new CartaoCredito(
                new BigDecimal("6000.00"),
                "**** 1234",
                3
        );

        boolean pagoCartao = pedido.pagar(cartao);

        System.out.println("Pagamento cartão aprovado: " + pagoCartao);
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Comprovante: " + pedido.getComprovante());

        // Boleto
        Boleto boleto = new Boleto(
                new BigDecimal("6000.00"),
                LocalDate.now().plusDays(3)
        );

        boolean pagoBoleto = pedido.pagar(boleto);

        System.out.println("Pagamento boleto aprovado: " + pagoBoleto);
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Comprovante: " + pedido.getComprovante());

        // Dinheiro
        Dinheiro dinheiro = new Dinheiro(
                new BigDecimal("7000.00")
        );

        boolean pagoDinheiro = pedido.pagar(dinheiro);

        System.out.println("Pagamento em dinheiro aprovado: " + pagoDinheiro);
        System.out.println("Situação: " + pedido.getSituacao());
        System.out.println("Comprovante: " + pedido.getComprovante());
    }
}
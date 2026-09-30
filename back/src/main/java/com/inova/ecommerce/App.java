package com.inova.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.inova.ecommerce.excecao.EstoqueInsuficienteException;
import com.inova.ecommerce.excecao.PagamentoRecusadoException;
import com.inova.ecommerce.excecao.PedidoInvalidoException;
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

        // Adicionando itens ao pedido
        try {
            pedido.adicionarItem(teclado, 2);
            pedido.adicionarItem(monitor, 1);

        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

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

        try {
            boolean pagoPix = pedido.pagar(pix);

            System.out.println("Pagamento aprovado: " + pagoPix);
            System.out.println("Situação: " + pedido.getSituacao());
            System.out.println("Comprovante: " + pedido.getComprovante());

        } catch (PagamentoRecusadoException e) {
            System.out.println("Erro no pagamento: " + e.getMessage());

        } catch (PedidoInvalidoException e) {
            System.out.println("Pedido inválido: " + e.getMessage());
        }

        // Cartão de crédito
        CartaoCredito cartao = new CartaoCredito(
            new BigDecimal("6000.00"),
            "**** 1234",
            3
        );

        try {
            boolean pagoCartao = pedido.pagar(cartao);

            System.out.println("Pagamento cartão aprovado: " + pagoCartao);
            System.out.println("Situação: " + pedido.getSituacao());
            System.out.println("Comprovante: " + pedido.getComprovante());

        } catch (PagamentoRecusadoException e) {
            System.out.println("Erro no pagamento: " + e.getMessage());

        } catch (PedidoInvalidoException e) {
            System.out.println("Pedido inválido: " + e.getMessage());
        }

        // Boleto
        Boleto boleto = new Boleto(
            new BigDecimal("6000.00"),
            LocalDate.now().plusDays(3)
        );

        try {
            boolean pagoBoleto = pedido.pagar(boleto);

            System.out.println("Pagamento boleto aprovado: " + pagoBoleto);
            System.out.println("Situação: " + pedido.getSituacao());
            System.out.println("Comprovante: " + pedido.getComprovante());

        } catch (PagamentoRecusadoException e) {
            System.out.println("Erro no pagamento: " + e.getMessage());

        } catch (PedidoInvalidoException e) {
            System.out.println("Pedido inválido: " + e.getMessage());
        }

        // Dinheiro
        Dinheiro dinheiro = new Dinheiro(
            new BigDecimal("7000.00")
        );

        try {
            boolean pagoDinheiro = pedido.pagar(dinheiro);

            System.out.println("Pagamento em dinheiro aprovado: " + pagoDinheiro);
            System.out.println("Situação: " + pedido.getSituacao());
            System.out.println("Comprovante: " + pedido.getComprovante());

        } catch (PagamentoRecusadoException e) {
            System.out.println("Erro no pagamento: " + e.getMessage());

        } catch (PedidoInvalidoException e) {
            System.out.println("Pedido inválido: " + e.getMessage());
        }

        // Teste de cliente com e-mail inválido
        try {
            new Cliente(
                "Cliente Teste",
                "111.111.111-11",
                "email-invalido",
                "(16) 99999-9999",
                "Rua Teste"
            );

        } catch (IllegalArgumentException e) {
            System.out.println(
                "Erro ao criar cliente: " + e.getMessage()
            );
        }

        // Teste de estoque insuficiente
        Produto produtoTeste = new Produto(
            "TES-001",
            "Produto Teste",
            new BigDecimal("100.00"),
            3
        );

        try {
            pedido.adicionarItem(produtoTeste, 50);

        } catch (EstoqueInsuficienteException e) {
            System.out.println(
                "Erro de estoque: " + e.getMessage()
            );
        }
        // Teste de preço negativo
try {
    new Produto(
        "TES-002",
        "Produto Inválido",
        new BigDecimal("-100.00"),
        5
    );

} catch (IllegalArgumentException e) {
    System.out.println(
        "Erro ao criar produto: " + e.getMessage()
    );
}
// Teste de pagamento recusado
Pedido pedidoRecusado = new Pedido(
    "PED-002",
    cliente
);

try {
    pedidoRecusado.adicionarItem(teclado, 1);

    CartaoCredito cartaoRecusado = new CartaoCredito(
        new BigDecimal("100.00"),
        "**** 9999",
        1
    );

    pedidoRecusado.pagar(cartaoRecusado);

} catch (EstoqueInsuficienteException e) {
    System.out.println("Erro de estoque: " + e.getMessage());

} catch (PagamentoRecusadoException e) {
    System.out.println(
        "Pagamento recusado: " + e.getMessage()
    );

    System.out.println(
        "Situação do pedido: " + pedidoRecusado.getSituacao()
    );

} catch (PedidoInvalidoException e) {
    System.out.println(
        "Pedido inválido: " + e.getMessage()
    );
}
// Teste de pedido vazio
Pedido pedidoVazio = new Pedido(
    "PED-003",
    cliente
);

try {
    pedidoVazio.pagar(pix);

} catch (PagamentoRecusadoException e) {
    System.out.println(
        "Pagamento recusado: " + e.getMessage()
    );

} catch (PedidoInvalidoException e) {
    System.out.println(
        "Pedido inválido: " + e.getMessage()
    );

    System.out.println(
        "Situação do pedido: " + pedidoVazio.getSituacao()
    );
}
// Teste de processador de pagamento nulo
Pedido pedidoNulo = new Pedido(
    "PED-004",
    cliente
);

try {
    pedidoNulo.adicionarItem(teclado, 1);
    pedidoNulo.pagar(null);

} catch (EstoqueInsuficienteException e) {
    System.out.println(
        "Erro de estoque: " + e.getMessage()
    );

} catch (IllegalArgumentException e) {
    System.out.println(
        "Erro no pagamento: " + e.getMessage()
    );

    System.out.println(
        "Situação do pedido: " + pedidoNulo.getSituacao()
    );

} catch (PagamentoRecusadoException e) {
    System.out.println(
        "Pagamento recusado: " + e.getMessage()
    );

} catch (PedidoInvalidoException e) {
    System.out.println(
        "Pedido inválido: " + e.getMessage()
    );
}
// Exemplo de finally
try {
    System.out.println("Executando operação...");

} finally {
    System.out.println("Finally executado.");
}
// Exemplo de try-with-resources
try (java.io.StringReader leitor =
        new java.io.StringReader("Teste")) {

    System.out.println("Recurso aberto com sucesso.");

} catch (Exception e) {
    System.out.println("Erro ao usar recurso: " + e.getMessage());
}
    }
}
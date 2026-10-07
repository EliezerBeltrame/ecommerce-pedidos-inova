package com.inova.ecommerce.util;

import java.time.LocalDate;
import java.util.Random;

/**
 * Cálculos e formatações de apoio ao módulo de pedidos.
 * Classe utilitária: todos os métodos são estáticos.
 */
public class PedidoUtils {

    private static final double VALOR_POR_QUILO = 7.50;
    private static final double FRETE_MINIMO = 15.00;
    private static final double TAXA_DESCONTO = 0.10;
    private static final double DESCONTO_MAXIMO = 50.00;
    private static final double VALOR_FRETE_GRATIS = 300.00;

    private static final Random SORTEIO = new Random();

    private PedidoUtils() {
        // classe utilitária não deve ser instanciada
    }

    /** Devolve um identificador no formato PED-AAAA-NNNNN. */
    public static String gerarNumeroDoPedido() {
        int sequencial = SORTEIO.nextInt(100000);
        return String.format("PED-%d-%05d", LocalDate.now().getYear(), sequencial);
    }

    /** Soma preço x quantidade de todos os itens. */
    public static double calcularSubtotal(double[] precos, int[] quantidades) {
        if (precos == null || quantidades == null || precos.length != quantidades.length) {
            throw new IllegalArgumentException("Preços e quantidades devem ter o mesmo tamanho");
        }
        double subtotal = 0.0;
        for (int i = 0; i < precos.length; i++) {
            subtotal += precos[i] * quantidades[i];
        }
        return subtotal;
    }

    /** Cobra por quilo iniciado, respeita o mínimo e zera acima do frete grátis. */
    public static double calcularFrete(double pesoEmQuilos, double subtotal) {
        if (pesoEmQuilos < 0) {
            throw new IllegalArgumentException("Peso não pode ser negativo");
        }
        if (subtotal > VALOR_FRETE_GRATIS) {
            return 0.0;
        }
        double quilosCobrados = Math.ceil(pesoEmQuilos);
        return Math.max(quilosCobrados * VALOR_POR_QUILO, FRETE_MINIMO);
    }

    /** Aplica a taxa de desconto e respeita o teto. */
    public static double calcularDesconto(double subtotal) {
        return Math.min(subtotal * TAXA_DESCONTO, DESCONTO_MAXIMO);
    }

    /** Devolve a linha do recibo alinhada em colunas. */
    public static String formatarLinhaDoRecibo(String nome, double preco, int quantidade) {
        return String.format("%-20s R$ %8.2f x%3d", nome, preco, quantidade);
    }
}
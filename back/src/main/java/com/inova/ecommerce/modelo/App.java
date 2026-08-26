package com.inova.ecommerce;

import com.inova.ecommerce.modelo.Produto;

public class App {

    public static void main(String[] args) {
        Produto teclado = new Produto("TEC-001", "Teclatek", "Teclado da bolivia", 2000.00, 10);
        Produto monitor = new Produto("TEC-002", "Monitek", "Monitor 30pol", 2000.00, 10);

        System.out.println(teclado);
        System.out.println(monitor);

        System.out.println(teclado.temEstoqueDisponivel(1500));
        System.out.println(monitor.temEstoqueDisponivel(200));

        teclado.baixarEstoque(1500);
        System.out.println(teclado);
    }
}
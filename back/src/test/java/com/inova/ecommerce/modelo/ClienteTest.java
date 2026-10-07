package com.inova.ecommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void prepararCenario() {
        cliente = new Cliente(
            "Joao Silva",
            "123.456.789-00",
            "joao@email.com",
            "16999999999",
            "Rua A"
        );
    }

    @Test
    @DisplayName("Deve criar cliente corretamente")
    void deveCriarClienteCorretamente() {

        assertEquals("Joao Silva", cliente.getNome());
        assertEquals("123.456.789-00", cliente.getCpf());
        assertEquals("joao@email.com", cliente.getEmail());
    }

    @Test
    @DisplayName("Deve permitir alterar o email")
    void deveAlterarEmail() {

        cliente.setEmail("novo@email.com");

        assertEquals("novo@email.com", cliente.getEmail());
    }

    @Test
    @DisplayName("Deve identificar clientes pelo documento")
    void deveCompararDocumento() {

        Cliente outroCliente = new Cliente(
            "Maria Silva",
            "987.654.321-00",
            "maria@email.com",
            "16888888888",
            "Rua B"
        );

        assertNotEquals(
            cliente.getCpf(),
            outroCliente.getCpf()
        );
    }
}
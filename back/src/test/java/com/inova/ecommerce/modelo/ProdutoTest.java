package com.inova.ecommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.inova.ecommerce.excecao.EstoqueInsuficienteException;

class ProdutoTest {

    private Produto notebook;

    @BeforeEach
    void prepararCenario() {
        notebook = new Produto(
            "PROD-001",
            "Notebook",
            new BigDecimal("3000.00"),
            5
        );
    }

    @Test
    @DisplayName("Deve criar produto corretamente")
    void deveCriarProdutoCorretamente() {

        assertEquals("PROD-001", notebook.getCodigo());
        assertEquals("Notebook", notebook.getNome());
        assertEquals(
            new BigDecimal("3000.00"),
            notebook.getPreco()
        );
        assertEquals(5, notebook.getQuantidadeEmEstoque());
        assertTrue(notebook.isAtivo());
    }

    @Test
    @DisplayName("Deve alterar o preço do produto")
    void deveAlterarPreco() {

        notebook.setPreco(new BigDecimal("3500.00"));

        assertEquals(
            new BigDecimal("3500.00"),
            notebook.getPreco()
        );
    }

    @Test
    @DisplayName("Deve alterar a quantidade em estoque")
    void deveAlterarQuantidadeEmEstoque() {

        notebook.setQuantidadeEmEstoque(10);

        assertEquals(
            10,
            notebook.getQuantidadeEmEstoque()
        );
    }

    @Test
    @DisplayName("Deve verificar estoque disponível")
    void deveVerificarEstoqueDisponivel() {

        assertTrue(
            notebook.temEstoqueDisponivel(3)
        );

        assertFalse(
            notebook.temEstoqueDisponivel(10)
        );
    }

    @Test
    @DisplayName("Produto inativo não deve ter estoque disponível")
    void produtoInativoNaoDeveTerEstoqueDisponivel() {

        notebook.setAtivo(false);

        assertFalse(
            notebook.temEstoqueDisponivel(1)
        );
    }

    @Test
    @DisplayName("Deve alterar a descrição")
    void deveAlterarDescricao() {

        notebook.setDescricao("Notebook para estudos");

        assertEquals(
            "Notebook para estudos",
            notebook.getDescricao()
        );
    }

    @Test
    @DisplayName("Deve alterar situação do produto")
    void deveAlterarSituacaoDoProduto() {

        notebook.setAtivo(false);

        assertFalse(notebook.isAtivo());

        notebook.setAtivo(true);

        assertTrue(notebook.isAtivo());
    }

    @Test
    @DisplayName("Deve baixar o estoque quando há quantidade suficiente")
    void deveBaixarEstoqueQuandoHaQuantidadeSuficiente()
            throws Exception {

        notebook.baixarEstoque(2);

        assertEquals(
            3,
            notebook.getQuantidadeEmEstoque()
        );
    }

    @Test
    @DisplayName("Deve lançar exceção quando não há estoque suficiente")
    void deveLancarExcecaoQuandoNaoHaEstoqueSuficiente() {

        EstoqueInsuficienteException excecao = assertThrows(
            EstoqueInsuficienteException.class,
            () -> notebook.baixarEstoque(10)
        );

        assertEquals(
            10,
            excecao.getQuantidadeSolicitada()
        );

        assertEquals(
            5,
            notebook.getQuantidadeEmEstoque()
        );

        assertTrue(
            excecao.getMessage().contains("Notebook")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50})
    @DisplayName("Deve rejeitar quantidade inválida")
    void deveRejeitarQuantidadeInvalida(int quantidade) {

        assertThrows(
            IllegalArgumentException.class,
            () -> notebook.baixarEstoque(quantidade)
        );
    }

    @Test
    @DisplayName("Deve rejeitar preço negativo")
    void deveRejeitarPrecoNegativo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> notebook.setPreco(new BigDecimal("-100.00"))
        );
    }

    @Test
    @DisplayName("Deve rejeitar estoque negativo")
    void deveRejeitarEstoqueNegativo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> notebook.setQuantidadeEmEstoque(-1)
        );
    }

    @Test
    @DisplayName("Deve rejeitar nome vazio")
    void deveRejeitarNomeVazio() {

        assertThrows(
            IllegalArgumentException.class,
            () -> notebook.setNome("")
        );
    }

    @Test
    @DisplayName("Deve rejeitar código vazio")
    void deveRejeitarCodigoVazio() {

        assertThrows(
            IllegalArgumentException.class,
            () -> new Produto(
                "",
                "Notebook",
                new BigDecimal("3000.00"),
                5
            )
        );
    }

    @Test
    @DisplayName("Deve gerar texto do produto")
    void deveGerarToString() {

        String resultado = notebook.toString();

        assertTrue(resultado.contains("PROD-001"));
        assertTrue(resultado.contains("Notebook"));
        assertTrue(resultado.contains("3000,00"));
        assertTrue(resultado.contains("5"));
    }
}
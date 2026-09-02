package com.inova.ecommerce.modelo;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEmEstoque;
    private boolean ativo;

    public Produto(String codigo, String nome, String descricao, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.ativo = true;
    }

    public boolean temEstoqueDisponivel(int quantidadeDesejada) {
        return ativo && this.quantidadeEmEstoque >= quantidadeDesejada;
    }

    public void baixarEstoque(int quantidade) {
        this.quantidadeEmEstoque = this.quantidadeEmEstoque - quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s - R$ %.2f (%d em estoque)",
                this.codigo, this.nome, this.descricao, this.preco, this.quantidadeEmEstoque);
    }
}
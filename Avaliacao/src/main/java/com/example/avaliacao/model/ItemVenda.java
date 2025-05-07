package com.example.avaliacao.model;

import jakarta.persistence.*;


@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Vendas venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;

    private Double precoUnitario;

    private Double subtotal;

    public ItemVenda() {
    }

    public ItemVenda(Vendas venda, Produto produto, int quantidade) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
        calcularSubtotal();

        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    private void calcularSubtotal() {
        this.subtotal = precoUnitario * (quantidade);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
        calcularSubtotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }
}

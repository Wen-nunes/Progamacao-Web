package com.example.avaliacao.request;

public class ItemVendaRequest {
    private Long produtoCodigo;
    private int quantidade;

    public ItemVendaRequest(Long produtoCodigo, int quantidade) {
        this.produtoCodigo = produtoCodigo;
        this.quantidade = quantidade;
    }

    public Long getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(Long produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

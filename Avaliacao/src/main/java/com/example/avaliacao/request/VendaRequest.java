package com.example.avaliacao.request;

import java.util.List;

public class VendaRequest {
private Long clienteId;
private List<ItemVendaRequest> itens;


    public VendaRequest(Long clienteId, List<ItemVendaRequest> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemVendaRequest> getItens() {
    return itens;
    }

    public void setItens(List<ItemVendaRequest> itens) {
    this.itens = itens;
    }

}
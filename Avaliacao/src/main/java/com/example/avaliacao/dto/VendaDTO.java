package com.example.avaliacao.dto;

import java.util.List;

public class VendaDTO {
    private Integer id;
    private Long clienteId;
    private List<ItemVendaDTO> itens;
    private Double valorTotal;

    public VendaDTO() {
    }

    public VendaDTO(Integer id, Long clienteId, List<ItemVendaDTO> itens, Double valorTotal) {
        this.id = id;
        this.clienteId = clienteId;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemVendaDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaDTO> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
} 
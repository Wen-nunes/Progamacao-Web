package com.example.avaliacao.service;

import com.example.avaliacao.dto.ItemVendaDTO;
import com.example.avaliacao.dto.VendaDTO;
import com.example.avaliacao.model.Cliente;
import com.example.avaliacao.model.ItemVenda;
import com.example.avaliacao.model.Produto;
import com.example.avaliacao.model.Vendas;
import com.example.avaliacao.repository.ClienteRepository;
import com.example.avaliacao.repository.ProdutoRepository;
import com.example.avaliacao.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public VendaDTO criarVenda(VendaDTO vendaDTO) {
        Cliente cliente = clienteRepository.findById(vendaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Vendas venda = new Vendas(cliente);
        List<ItemVenda> itens = new ArrayList<>();

        for (ItemVendaDTO itemDTO : vendaDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            if (produto.getQuantidade() < itemDTO.getQuantidade()) {
                throw new RuntimeException("Quantidade insuficiente do produto: " + produto.getNome());
            }

            ItemVenda item = new ItemVenda(venda, produto, itemDTO.getQuantidade());
            itens.add(item);
        }

        venda.setItens(itens);
        Vendas vendaSalva = vendaRepository.save(venda);

        return converterParaDTO(vendaSalva);
    }

    public VendaDTO buscarVenda(Integer id) {
        Vendas venda = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        return converterParaDTO(venda);
    }

    public List<VendaDTO> listarVendas() {
        return vendaRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private VendaDTO converterParaDTO(Vendas venda) {
        VendaDTO dto = new VendaDTO();
        dto.setId(venda.getId());
        dto.setClienteId(venda.getCliente().getId());
        dto.setValorTotal(venda.getValorTotal());

        List<ItemVendaDTO> itensDTO = venda.getItens().stream()
                .map(item -> {
                    ItemVendaDTO itemDTO = new ItemVendaDTO();
                    itemDTO.setId(item.getId());
                    itemDTO.setProdutoId(item.getProduto().getCodigo());
                    itemDTO.setQuantidade(item.getQuantidade());
                    itemDTO.setPrecoUnitario(item.getPrecoUnitario());
                    itemDTO.setSubtotal(item.getSubtotal());
                    return itemDTO;
                })
                .collect(Collectors.toList());

        dto.setItens(itensDTO);
        return dto;
    }
} 
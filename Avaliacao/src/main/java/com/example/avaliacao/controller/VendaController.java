package com.example.avaliacao.controller;

import com.example.avaliacao.model.Cliente;
import com.example.avaliacao.model.ItemVenda;
import com.example.avaliacao.model.Produto;
import com.example.avaliacao.model.Vendas;
import com.example.avaliacao.repository.ClienteRepository;
import com.example.avaliacao.repository.ProdutoRepository;
import com.example.avaliacao.repository.VendaRepository;
import com.example.avaliacao.request.ItemVendaRequest;
import com.example.avaliacao.request.VendaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @PostMapping
    public ResponseEntity<Vendas> realizarVenda(@RequestBody VendaRequest vendaRequest) {
        Optional<Cliente> cliente = clienteRepository.findById(vendaRequest.getClienteId());
        if (cliente.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<ItemVenda> itens = new ArrayList<>();
        for (ItemVendaRequest itemRequest : vendaRequest.getItens()) {
            Optional<Produto> produto = produtoRepository.findByCodigo(itemRequest.getProdutoCodigo());
            if (produto.isEmpty() || produto.get().getQuantidade() < itemRequest.getQuantidade()) {
                return ResponseEntity.badRequest().build();
            }
            itens.add(new ItemVenda(null, produto.get(), itemRequest.getQuantidade()));
        }

        Vendas venda = new Vendas(cliente.get(), itens);
        for (ItemVenda item : itens) item.setVenda(venda);

        return ResponseEntity.ok(vendaRepository.save(venda));
    }
}
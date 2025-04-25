package com.example.avaliacao.controller;

import com.example.avaliacao.model.Cliente;
import com.example.avaliacao.model.Produto;
import com.example.avaliacao.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProduto() {
        return produtoService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long codigo) {
        Optional<Produto> produto = produtoService.findByCodigo(codigo);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long codigo, @RequestBody Produto produtoAtualizado) {
        try {
            Produto produto = produtoService.updateProduto(codigo, produtoAtualizado);
            return ResponseEntity.ok(produto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long codigo) {
        if (produtoService.existsByCodigo(codigo)) {
            produtoService.deleteByCodigo(codigo);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

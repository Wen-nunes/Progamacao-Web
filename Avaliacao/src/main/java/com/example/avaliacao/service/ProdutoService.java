package com.example.avaliacao.service;

import com.example.avaliacao.model.Cliente;
import com.example.avaliacao.model.Produto;
import com.example.avaliacao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findByCodigo(Long codigo) {
        return produtoRepository.findById(codigo);
    }

    public boolean existsByCodigo(Long codigo) {
        return produtoRepository.existsById(codigo);
    }

    public void deleteByCodigo(Long codigo) {
        produtoRepository.deleteById(codigo);
    }

    public Produto updateProduto(Long codigo, Produto produtoAtualizado) {
        Produto produtoExistente = produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Produto com código " + codigo + " não encontrado"));

        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setPreco(produtoAtualizado.getPreco());
        produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());

        return produtoRepository.save(produtoExistente);
    }


}

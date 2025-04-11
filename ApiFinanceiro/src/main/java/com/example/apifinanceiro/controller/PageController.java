package com.example.apifinanceiro.controller;

import com.example.apifinanceiro.model.Cliente;
import com.example.apifinanceiro.model.Mercadoria;
import com.example.apifinanceiro.model.Venda;
import com.example.apifinanceiro.repository.ClienteRepository;
import com.example.apifinanceiro.repository.MercadoriaRepository;
import com.example.apifinanceiro.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cliente")
    public String cliente(Model model) {
        List<Mercadoria> produtos = mercadoriaRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "cliente";
    }

    @GetMapping("/fornecedor")
    public String fornecedor(Model model) {
        List<Mercadoria> produtos = mercadoriaRepository.findAll();
        List<Venda> vendas = vendaRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("vendas", vendas);
        return "fornecedor";
    }
} 
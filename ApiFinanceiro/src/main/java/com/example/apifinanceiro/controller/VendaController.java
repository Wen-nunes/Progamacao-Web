package com.example.apifinanceiro.controller;

import com.example.apifinanceiro.model.Venda;
import com.example.apifinanceiro.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    private static final int MAX_PARCELAS = 10;
    private static final float TAXA_ICMS = 0.18f; // 18% de ICMS

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVenda(@PathVariable int id) {
        return vendaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        try {
            // Validação do número de parcelas
            if (venda.getNumero_parcelas() > MAX_PARCELAS) {
                return ResponseEntity.badRequest().build();
            }

            // Validação de forma de pagamento
            if (venda.isDebito() && venda.isCredito()) {
                return ResponseEntity.badRequest().build();
            }

            // Validação de mercadorias
            if (venda.getMercadorias() == null || venda.getMercadorias().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            // Calcula o valor total da venda
            float valorTotal = 0;
            for (var mercadoria : venda.getMercadorias()) {
                valorTotal += mercadoria.getPreco_venda() * mercadoria.getQuantidade();
            }
            venda.setValor_total(valorTotal);

            // Calcula o ICMS sobre o valor total
            float icms = valorTotal * TAXA_ICMS;
            venda.setIcms(icms);

            // Configura o pagamento
            if (venda.isDebito()) {
                venda.setCredito(false);
                venda.setNumero_parcelas(0);
                venda.setValor_parcela(0);
            } else if (venda.isCredito()) {
                venda.setDebito(false);
                if (venda.getNumero_parcelas() <= 0) {
                    return ResponseEntity.badRequest().build();
                }
                float valorParcela = (valorTotal + icms) / venda.getNumero_parcelas();
                venda.setValor_parcela(valorParcela);
            } else {
                return ResponseEntity.badRequest().build();
            }

            Venda vendaSalva = vendaRepository.save(venda);
            return ResponseEntity.ok(vendaSalva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable int id) {
        return vendaRepository.findById(id)
                .map(venda -> {
                    vendaRepository.delete(venda);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 
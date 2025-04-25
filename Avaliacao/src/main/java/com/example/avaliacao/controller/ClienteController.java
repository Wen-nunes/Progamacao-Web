package com.example.avaliacao.controller;

import com.example.avaliacao.model.Cliente;
import com.example.avaliacao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) {
        Optional<Cliente> cliente = clienteService.findByCpf(cpf);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        try {
            Cliente cliente = clienteService.updateCliente(id, clienteAtualizado);
            return ResponseEntity.ok(cliente);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (clienteService.existsById(id)) {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

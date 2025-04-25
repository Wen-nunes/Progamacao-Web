package com.example.avaliacao.service;

import com.example.avaliacao.model.Cliente;
import com.example.avaliacao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        if(ClienteRepository.existsByEmail(cliente.getEmail())){
            throw new IllegalArgumentException("Cliente com esse e-mail já existe.");
        }

        return clienteRepository.save(cliente);
    }


    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }


    public Optional<Cliente> findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente com ID " + id + " não encontrado"));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setCpf(clienteAtualizado.getCpf());

        return clienteRepository.save(clienteExistente);
    }

}

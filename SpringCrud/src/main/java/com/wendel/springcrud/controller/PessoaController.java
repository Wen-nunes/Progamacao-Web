package com.wendel.springcrud.controller;

import com.wendel.springcrud.model.Pessoa;
import com.wendel.springcrud.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    //listando as pessoas cadastradas na lista
    @GetMapping
    public List<Pessoa> findAll() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }
    //listando as pesoas da lista pelo seu id
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable int id) {
        return pessoaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //buscando pessoas pelo cpf
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> buscarPessoaPorCpf(@PathVariable String cpf) {
        return pessoaRepository.findByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //cria uma nova pessoa
    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
       pessoaRepository.save(pessoa);
       return pessoa;
    }

    //atualizando uma pessoa
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable int id, @RequestBody Pessoa pessoaAtualizada){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cpf não cadastrado com o id: " + id));
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setCpf(pessoaAtualizada.getCpf());
        pessoa.setEmail(pessoaAtualizada.getEmail());
        pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> remover(@PathVariable int id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

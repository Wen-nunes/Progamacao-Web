package com.projeto1.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/pessoa")
public class PessoaCotroller {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/save")
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }
}

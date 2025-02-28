package com.wendel.springcrud.repository;

import com.wendel.springcrud.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {


    Optional<Pessoa> findByCpf(String cpf);
}

package com.example.avaliacao.repository;

import com.example.avaliacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    static boolean existsByEmail(String email) {
        return false;
    }

    Optional<Cliente> findByCpf(String cpf);
}

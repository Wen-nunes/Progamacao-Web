package com.example.avaliacao.repository;

import com.example.avaliacao.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Vendas, Integer> {

    Vendas save(Vendas venda);
}
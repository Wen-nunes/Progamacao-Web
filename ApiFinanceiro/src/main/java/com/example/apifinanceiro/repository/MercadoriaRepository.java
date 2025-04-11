package com.example.apifinanceiro.repository;

import com.example.apifinanceiro.model.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, Integer> {
} 
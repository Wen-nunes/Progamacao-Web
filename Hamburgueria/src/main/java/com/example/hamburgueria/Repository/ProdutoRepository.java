package com.example.hamburgueria.Repository;

import com.example.hamburgueria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}

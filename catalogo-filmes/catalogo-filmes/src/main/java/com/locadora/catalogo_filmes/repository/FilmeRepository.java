package com.locadora.catalogo_filmes.repository;

import com.locadora.catalogo_filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}

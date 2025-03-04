package com.locadora.catalogo_filmes.service;

import com.locadora.catalogo_filmes.model.Filme;
import com.locadora.catalogo_filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> findById(Long id) {
        return filmeRepository.findById(id);
    }

    public Filme save(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }
}
